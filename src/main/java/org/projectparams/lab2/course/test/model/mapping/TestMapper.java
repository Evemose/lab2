package org.projectparams.lab2.course.test.model.mapping;

import org.mapstruct.Mapper;
import org.projectparams.lab2.course.test.model.dto.TestPreviewDTO;
import org.projectparams.lab2.course.test.model.entities.Test;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestPreviewDTO toPreviewDTO(Test test, Boolean isPassed);
}
