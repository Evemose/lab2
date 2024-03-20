package org.projectparams.lab2.course.test.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TestPreviewDTO(
        Long id,
        String name,
        @Nullable Boolean isPassed
) {
}
