package org.projectparams.lab2.course.article.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;
import org.projectparams.lab2.course.model.entities.Course;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String title;

    @ElementCollection
    @NotEmpty
    List<Section> sections = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    Course course;
}
