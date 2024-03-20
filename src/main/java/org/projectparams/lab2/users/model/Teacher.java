package org.projectparams.lab2.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projectparams.lab2.course.model.entities.Course;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Teacher extends User {
    @ManyToMany(mappedBy = "teachers")
    List<Course> courses = new ArrayList<>();
}
