package org.projectparams.lab2.course.test.model.dto;

public record GetQuestionDTO(
        Integer questionId,
        String text,
        GetAnswerOptionDTO[] answerOptions
) {
}
