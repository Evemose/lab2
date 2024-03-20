package org.projectparams.lab2.users.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.projectparams.lab2.users.model.entities.Student;
import org.projectparams.lab2.users.model.entities.Teacher;
import org.projectparams.lab2.users.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLookupServiceImpl implements UserLookupService {
    final StudentService studentService;
    final TeacherService teacherService;

    @Override
    public Optional<User> findById(Long id) {
        return studentService.findById(id).map(User.class::cast)
                .or(() -> teacherService.findById(id).map(User.class::cast));
    }

    @Override
    public void save(User entity) {
        if (entity instanceof Teacher) {
            teacherService.save((Teacher) entity);
        } else {
            studentService.save((Student) entity);
        }
    }

    @Override
    public User findByUsername(String username) {
        var student = studentService.findByUsername(username);
        if (student.isPresent()) {
            return student.get();
        }
        return teacherService.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
}
