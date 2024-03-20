package org.projectparams.lab2.users.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.projectparams.lab2.course.model.dto.GetCourseDTO;
import org.projectparams.lab2.course.test.model.dto.GetAttemptDTO;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GetStudentDTO extends GetUserDTO {
    final List<GetAttemptDTO> attempts;
    final GetCourseDTO[] courses;

    public GetStudentDTO(Long id, String username, List<GetAttemptDTO> attempts, GetCourseDTO[] courses) {
        super(id, username);
        this.attempts = attempts;
        this.courses = courses;
    }
}
