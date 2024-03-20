package org.projectparams.lab2.users.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.projectparams.lab2.users.model.dto.GetStudentDTO;
import org.projectparams.lab2.users.model.mapping.StudentMapper;
import org.projectparams.lab2.users.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Delegate(types = StudentService.class)
    final StudentRepository studentRepository;
    final StudentMapper studentMapper;

    @Override
    public GetStudentDTO getInfo(String username) {
        return studentRepository.findByUsername(username)
                .map(studentMapper::toGetDTO)
                .orElseThrow(EntityNotFoundException::new);
    }
}
