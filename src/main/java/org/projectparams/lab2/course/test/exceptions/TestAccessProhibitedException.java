package org.projectparams.lab2.course.test.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
public class TestAccessProhibitedException extends RuntimeException {
    final Long testId;
    final String studentUsername;
    final String reason;

    @Override
    public String getMessage() {
        return "Access to test " + testId + " is prohibited for student " + studentUsername + ": " + reason;
    }

}
