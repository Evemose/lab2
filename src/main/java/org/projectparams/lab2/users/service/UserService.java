package org.projectparams.lab2.users.service;

import org.projectparams.lab2.commons.BasicService;
import org.projectparams.lab2.users.model.dto.GetUserDTO;
import org.projectparams.lab2.users.model.entities.User;

import java.util.Optional;

public interface UserService<E extends User, D extends GetUserDTO> extends BasicService<E> {

    Optional<E> findByUsername(String username);

    D getInfo(String username);
}
