package org.projectparams.lab2.course.article.model.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.projectparams.lab2.course.article.model.dto.ArticleDTO;
import org.projectparams.lab2.course.article.model.dto.ArticlePreviewDTO;
import org.projectparams.lab2.course.article.model.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@SuppressWarnings("all")
public abstract class ArticleMapper {
    @Autowired
    protected SectionMapper sectionMapper;

    @Mapping(target = "sections", expression = "java(article.getSections().stream()" +
            ".map(sectionMapper::toDTO).toList())")
    public abstract ArticleDTO toDTO(Article article);

    @Mapping(target = "sections", expression = "java(article.getSections().stream()" +
            ".map(s -> s.getTitle()).toArray(String[]::new))")
    public abstract ArticlePreviewDTO toPreviewDTO(Article article);
}
