package org.projectparams.lab2.users.model.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.projectparams.lab2.course.test.model.mapping.AttemptMapper;
import org.projectparams.lab2.users.model.dto.GetStudentDTO;
import org.projectparams.lab2.users.model.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@SuppressWarnings("all")
public abstract class StudentMapper {
    @Autowired
    protected AttemptMapper attemptMapper;

    @Mapping(target = "attempts",
            expression = "java(student.getAttempts().stream().map(attemptMapper::toGetDTO).toList())")
    @Mapping(target = "courses",
            expression = "java(student.getCourses().stream().map(course -> course.getId()).toArray(GetCourseDTO[]::new))")
    public abstract GetStudentDTO toGetDTO(Student student);
}
