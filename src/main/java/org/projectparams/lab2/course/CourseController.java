package org.projectparams.lab2.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @GetMapping("{id}/students")
    public ResponseEntity<?> getStudents(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
