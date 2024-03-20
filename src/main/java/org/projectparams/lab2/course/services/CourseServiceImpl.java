package org.projectparams.lab2.course.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.projectparams.lab2.course.model.dto.StudentCourseStatsDTO;
import org.projectparams.lab2.course.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Delegate(types = CourseService.class)
    final CourseRepository courseRepository;

    @Override
    public List<StudentCourseStatsDTO> getStudentCourseStats(Long courseId) {
        var course = courseRepository.findById(courseId)
                .orElseThrow(EntityNotFoundException::new);
        return null;
    }


}
