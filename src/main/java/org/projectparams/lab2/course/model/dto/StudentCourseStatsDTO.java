package org.projectparams.lab2.course.model.dto;

public record StudentCourseStatsDTO(
        Long courseId,
        Long studentId,
        StudentTestStatsDTO[] tests
) {
}
