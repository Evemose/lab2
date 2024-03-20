package org.projectparams.lab2.course.article.model.dto;

import java.util.List;

public record ArticleDTO(
        Long id,
        String title,
        List<SectionDTO> sections
) {
}
