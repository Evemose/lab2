package org.projectparams.lab2.course.article.model.mapping;

import org.mapstruct.Mapper;
import org.projectparams.lab2.course.article.model.dto.SectionDTO;
import org.projectparams.lab2.course.article.model.entities.Section;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    SectionDTO toDTO(Section section);
}
