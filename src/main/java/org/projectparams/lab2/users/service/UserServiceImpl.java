package org.projectparams.lab2.users.service;

import lombok.RequiredArgsConstructor;
import org.projectparams.lab2.users.model.User;
import org.projectparams.lab2.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;


    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
