package org.projectparams.lab2.users.service;

import org.projectparams.lab2.commons.BasicService;
import org.projectparams.lab2.users.model.entities.User;

public interface UserLookupService extends BasicService<User> {
    User findByUsername(String username);
}
