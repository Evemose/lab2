package org.projectparams.lab2.users;

import org.projectparams.lab2.users.service.StudentService;
import org.projectparams.lab2.users.service.TeacherService;
import org.projectparams.lab2.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@RestController
@RequestMapping("/me")
public class UserController {
    final Map<String, UserService<?, ?>> serviceRouter;

    public UserController(StudentService studentService, TeacherService teacherService) {
        serviceRouter = Map.of(
                "STUDENT", studentService,
                "TEACHER", teacherService
        );
    }

    @GetMapping
    public ResponseEntity<?> getResults(Principal principal) {
        var auth = getContext().getAuthentication();
        return ResponseEntity.ok(
                serviceRouter.get(
                        auth.getAuthorities().iterator().next().getAuthority().substring(5)
                ).getInfo(principal.getName()));

    }
}
