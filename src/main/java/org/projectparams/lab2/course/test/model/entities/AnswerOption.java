package org.projectparams.lab2.course.test.model.entities;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerOption {

    @NonNull
    String text;
}
