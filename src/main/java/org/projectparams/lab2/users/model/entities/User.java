package org.projectparams.lab2.users.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.projectparams.lab2.course.model.entities.Course;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Data
public abstract class User {
    @Id
    @GeneratedValue
    protected Long id;
    @NotNull
    @NotBlank
    @Column(unique = true)
    protected String username;
    @ManyToMany
    @ToString.Exclude
    protected List<Course> courses = new ArrayList<>();
}
