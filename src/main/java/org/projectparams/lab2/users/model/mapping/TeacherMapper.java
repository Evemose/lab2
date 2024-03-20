package org.projectparams.lab2.users.model.mapping;

import org.mapstruct.Mapper;
import org.projectparams.lab2.users.model.dto.GetTeacherDTO;
import org.projectparams.lab2.users.model.entities.Teacher;

@Mapper(componentModel = "spring")
public abstract class TeacherMapper {
    public abstract GetTeacherDTO toGetDTO(Teacher teacher);
}