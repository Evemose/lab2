package org.projectparams.lab2.course.test.model.dto;

import org.projectparams.lab2.users.model.dto.GetStudentDTO;
import org.projectparams.lab2.users.model.dto.GetTeacherDTO;

public record GetTestDTO(
        Long id,
        String name,
        String description,
        GetQuestionDTO[] questions,
        Integer timeLimit,
        Integer attemptsLimit,
        GetTeacherDTO teacher,
        GetStudentDTO[] allowedStudents

) {
}
