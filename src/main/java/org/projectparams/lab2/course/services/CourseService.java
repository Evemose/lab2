package org.projectparams.lab2.course.services;

import org.projectparams.lab2.commons.BasicService;
import org.projectparams.lab2.course.model.dto.StudentCourseStatsDTO;
import org.projectparams.lab2.course.model.entities.Course;

import java.util.List;

public interface CourseService extends BasicService<Course> {
    List<StudentCourseStatsDTO> getStudentCourseStats(Long courseId);
}
