package org.projectparams.lab2.course.model.dto;

import org.projectparams.lab2.course.article.model.dto.ArticlePreviewDTO;
import org.projectparams.lab2.course.test.model.dto.TestPreviewDTO;
import org.projectparams.lab2.users.model.dto.UserPreviewDTO;

public record GetCourseDTO(
        Long id,
        String name,
        TestPreviewDTO[] tests,
        ArticlePreviewDTO[] articles,
        UserPreviewDTO[] students,
        UserPreviewDTO[] teachers
) {
}
