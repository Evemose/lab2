package org.projectparams.lab2.users.service;

import org.projectparams.lab2.commons.BasicService;
import org.projectparams.lab2.users.model.User;

import java.util.Optional;

public interface UserService extends BasicService<User> {
    Optional<User> findByUsername(String username);
}
