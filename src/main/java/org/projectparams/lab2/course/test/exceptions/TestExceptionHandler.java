package org.projectparams.lab2.course.test.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TestExceptionHandler {

    @ExceptionHandler(TestAccessProhibitedException.class)
    public ResponseEntity<?> handleTestAccessProhibitedException(TestAccessProhibitedException e) {
        return ResponseEntity.badRequest().body(Error.from(e));
    }

    private record Error(String message, Long testId, String studentUsername) {
        static Error from(TestAccessProhibitedException e) {
            return new Error(e.getMessage(), e.getTestId(), e.getStudentUsername());
        }
    }

}
