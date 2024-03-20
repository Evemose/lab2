package org.projectparams.lab2.course.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.projectparams.lab2.course.model.dto.StudentCourseStatsDTO;
import org.projectparams.lab2.course.model.dto.StudentTestStatsDTO;
import org.projectparams.lab2.course.repositories.CourseRepository;
import org.projectparams.lab2.course.test.model.dto.GetAttemptDTO;
import org.projectparams.lab2.course.test.model.mapping.AttemptMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Delegate(types = CourseService.class)
    final CourseRepository courseRepository;

    final AttemptMapper attemptMapper;

    @Override
    public List<StudentCourseStatsDTO> getStudentCourseStats(Long courseId) {
        var course = courseRepository.findById(courseId)
                .orElseThrow(EntityNotFoundException::new);
        return course.getStudents().stream()
                .map(student -> new StudentCourseStatsDTO(
                        courseId,
                        student.getId(),
                        course.getTests().stream()
                                .map(test -> new StudentTestStatsDTO(
                                                test.getId(),
                                                student.getId(),
                                                student.getAttempts().stream()
                                                        .filter(attempt -> attempt.getTest().getId().equals(test.getId()))
                                                        .map(attempt -> attemptMapper.toGetDTO(
                                                                attempt,
                                                                test.getAttempts().stream()
                                                                        .filter(attempt1 ->
                                                                                attempt1.getStudent().getId().equals(student.getId())
                                                                        ).toList().indexOf(attempt)
                                                        ))
                                                        .toArray(GetAttemptDTO[]::new)
                                        )
                                ).toArray(StudentTestStatsDTO[]::new)
                ))
                .toList();
    }


}
