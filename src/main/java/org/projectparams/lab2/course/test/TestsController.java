package org.projectparams.lab2.course.test;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.projectparams.lab2.course.test.model.dto.PostAnswerDTO;
import org.projectparams.lab2.course.test.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestsController {

    final TestService testService;

    @PostMapping("/{testId}/attempts")
    public ResponseEntity<?> registerAttempt(@PathVariable("testId") Long testId, Principal principal) {
        testService.registerAttempt(principal.getName(), testId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{testId}/attempts")
    public ResponseEntity<?> submitAnswer(
            @PathVariable("testId") Long testId,
            @RequestBody PostAnswerDTO answer,
            Principal principal) {
        testService.setAnswer(testId, principal.getName(), answer.questionId(), answer.answerOptionNumber());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{testId}/attempts/submit")
    public ResponseEntity<?> submitAttempt(@PathVariable("testId") Long testId, Principal principal) {
        testService.submitAttempt(principal.getName(), testId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/attempts")
    public ResponseEntity<?> getAttempts(@RequestParam("testId") Long testId) {
        return ResponseEntity.ok(testService.findById(testId)
                .orElseThrow(EntityNotFoundException::new)
                .getAttempts());

    }
}
