package org.projectparams.lab2.course.article.model.dto;

public record ArticlePreviewDTO(
        Long id,
        String title,
        String[] sections
) {
}
