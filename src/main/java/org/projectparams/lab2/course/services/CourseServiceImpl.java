package org.projectparams.lab2.course.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.projectparams.lab2.course.model.dto.StudentCourseStatsDTO;
import org.projectparams.lab2.course.model.dto.StudentTestStatsDTO;
import org.projectparams.lab2.course.repositories.CourseRepository;
import org.projectparams.lab2.course.test.model.dto.GetAttemptDTO;
import org.projectparams.lab2.course.test.model.mapping.AttemptMapper;
import org.projectparams.lab2.course.test.service.TestService;
import org.projectparams.lab2.users.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Delegate(types = CourseService.class)
    final CourseRepository courseRepository;
    final AttemptMapper attemptMapper;
    final StudentService studentService;
    final TestService testService;

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
                                                .map(attemptMapper::toGetDTO).toArray(GetAttemptDTO[]::new)
                                )).toArray(StudentTestStatsDTO[]::new)
                )).toList();
    }


}
