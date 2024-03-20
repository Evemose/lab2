package org.projectparams.lab2.course.test.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GetAttemptDTO(
        Long id,
        Long studentId,
        Long testId,
        Byte attemptNumber,
        Long score,
        Long duration
) {
}
