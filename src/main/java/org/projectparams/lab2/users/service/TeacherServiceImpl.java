package org.projectparams.lab2.users.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.projectparams.lab2.users.model.dto.GetTeacherDTO;
import org.projectparams.lab2.users.model.mapping.TeacherMapper;
import org.projectparams.lab2.users.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    @Delegate(types = TeacherService.class)
    final TeacherRepository teacherRepository;
    final TeacherMapper teacherMapper;

    @Override
    public GetTeacherDTO getInfo(String username) {
        return teacherRepository.findByUsername(username)
                .map(teacherMapper::toGetDTO).orElseThrow(EntityNotFoundException::new);
    }
}
