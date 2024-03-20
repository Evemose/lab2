package org.projectparams.lab2.course.article.model.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Embeddable
@Data
public class Section {

    @NotBlank
    String title;

    @NotNull
    @NotBlank
    String content;

    @Nullable
    @NotBlank
    @URL
    String videoUrl;
}
