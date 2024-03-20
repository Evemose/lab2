package org.projectparams.lab2.course.test.model.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.projectparams.lab2.course.test.model.dto.GetAttemptDTO;
import org.projectparams.lab2.course.test.model.entities.Attempt;

@Mapper(componentModel = "spring")
public interface AttemptMapper {
    @Mapping(target = "studentId", expression = "java(attempt.getStudent().getId())")
    @Mapping(target = "testId", expression = "java(attempt.getTest().getId())")
    GetAttemptDTO toGetDTO(Attempt attempt);
}
