package org.projectparams.lab2.course.test.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.projectparams.lab2.course.test.exceptions.TestAccessProhibitedException;
import org.projectparams.lab2.course.test.model.dto.GetAttemptDTO;
import org.projectparams.lab2.course.test.model.entities.Attempt;
import org.projectparams.lab2.course.test.model.mapping.AttemptMapper;
import org.projectparams.lab2.course.test.repository.AttemptRepository;
import org.projectparams.lab2.course.test.repository.QuestionRepository;
import org.projectparams.lab2.course.test.repository.TestRepository;
import org.projectparams.lab2.users.model.Student;
import org.projectparams.lab2.users.service.UserService;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class TestSerivceImpl implements TestService {

    @Delegate(types = TestService.class)
    final TestRepository testRepository;
    final UserService userService;
    final AttemptRepository attemptRepository;
    final TaskScheduler taskScheduler;
    final AttemptMapper attemptMapper;
    private final QuestionRepository questionRepository;

    @Override
    public int getStudentAttemptsCount(String studentUsername, Long testId) {
        return attemptRepository.countByStudent_UsernameAndTest_Id(studentUsername, testId);
    }

    @Override
    @Transactional
    public GetAttemptDTO registerAttempt(String username, Long testId) {
        var user = userService.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        if (!(user instanceof Student)) {
            throw new TestAccessProhibitedException(testId, username, "User is not a student");
        }
        var test = testRepository.findById(testId)
                .orElseThrow(EntityNotFoundException::new);
        if (!test.getAllowedStudents().contains(user)) {
            throw new TestAccessProhibitedException(testId, username, "User not allowed to take this test");
        }
        var attemptsCount = getStudentAttemptsCount(username, testId);
        if (attemptsCount >= test.getAttemptsLimit()) {
            throw new TestAccessProhibitedException(testId, username, "User exceeded max attempts count");
        }
        if (attemptRepository.findByClosedIsFalseAndStudent_UsernameAndTest_Id(username, testId).isPresent()) {
            throw new TestAccessProhibitedException(testId, username, "User already has an open attempt");
        }
        var attempt = new Attempt((Student) user, test);
        attemptRepository.save(attempt);
        test.getAttempts().add(attempt);
        testRepository.save(test);
        return attemptMapper.toGetDTO(attempt, attemptsCount + 1);
    }

    @Override
    public void setAnswer(
            Long testId,
            String username,
            Long questionId,
            Integer answerOptionNumber) {
        var attempt = attemptRepository.findByClosedIsFalseAndStudent_UsernameAndTest_Id(
                username,
                testId
        ).orElseThrow(EntityNotFoundException::new);
        var question = questionRepository.findById(questionId)
                .orElseThrow(EntityNotFoundException::new);
        if (answerOptionNumber >= question.getAnswerOptions().size()) {
            throw new EntityNotFoundException("Answer option not found");
        }
        attempt.getAnswers().put(
                question,
                question.getAnswerOptions().get(answerOptionNumber)
        );
        attemptRepository.save(attempt);
        scheduleAttemptClosing(attempt);
    }

    @Override
    @Transactional
    public void submitAttempt(String username, Long testId) {
        var attempt = attemptRepository.findByClosedIsFalseAndStudent_UsernameAndTest_Id(
                username,
                testId
        ).orElseThrow(EntityNotFoundException::new);
        attempt.setDuration((int) (Instant.now().getEpochSecond() -
                attempt.getStartedAt().atZone(ZoneId.systemDefault()).toEpochSecond()));
        attempt.setClosed(true);
        attemptRepository.save(attempt);
    }

    private void scheduleAttemptClosing(Attempt attempt) {
        taskScheduler.schedule(() -> {
            attempt.setClosed(true);
            attempt.setDuration(attempt.getTest().getTimeLimit());
            // TODO: calculate score
            attempt.setScore(0.0);
            attemptRepository.save(attempt);
        }, Instant.now().plusSeconds(attempt.getTest().getTimeLimit()));
    }
}
