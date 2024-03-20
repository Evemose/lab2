package org.projectparams.lab2.course.model.dto;

import org.projectparams.lab2.course.test.model.dto.GetAttemptDTO;

public record StudentTestStatsDTO(
        Long testId,
        Long studentId,
        GetAttemptDTO[] attempts
) {
}
