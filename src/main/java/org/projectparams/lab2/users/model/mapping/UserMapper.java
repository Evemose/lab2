package org.projectparams.lab2.users.model.mapping;

import org.mapstruct.Mapper;
import org.projectparams.lab2.users.model.dto.UserPreviewDTO;
import org.projectparams.lab2.users.model.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserPreviewDTO toPreviewDTO(User user);
}
