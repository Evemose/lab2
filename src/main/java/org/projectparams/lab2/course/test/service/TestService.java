package org.projectparams.lab2.course.test.service;

import org.projectparams.lab2.commons.BasicService;
import org.projectparams.lab2.course.test.model.entities.Test;

public interface TestService extends BasicService<Test> {
    int getStudentAttemptsCount(String studentUsername, Long testId);

    void registerAttempt(String username, Long testId);

    void setAnswer(Long testId, String username, Long questionId, Integer answerOptionNumber);

    void submitAttempt(String username, Long testId);
}
