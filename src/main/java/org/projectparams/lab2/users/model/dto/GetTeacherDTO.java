package org.projectparams.lab2.users.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GetTeacherDTO extends GetUserDTO {
    public GetTeacherDTO(Long id, String username) {
        super(id, username);
    }
}
