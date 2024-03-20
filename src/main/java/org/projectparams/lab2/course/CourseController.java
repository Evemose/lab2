package org.projectparams.lab2.course;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.projectparams.lab2.course.model.mapping.CourseMapper;
import org.projectparams.lab2.course.services.CourseService;
import org.projectparams.lab2.users.service.UserLookupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    final CourseService courseService;
    final CourseMapper courseMapper;
    final UserLookupService userLookupService;

    @GetMapping("/{id}/students")
    public ResponseEntity<?> getStudents(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getStudentCourseStats(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(
                courseMapper.toGetDTO(
                        courseService.findById(id).orElseThrow(EntityNotFoundException::new),
                        userLookupService.findByUsername(principal.getName())
                )
        );
    }

}
