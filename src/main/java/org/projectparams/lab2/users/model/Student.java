package org.projectparams.lab2.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projectparams.lab2.course.model.entities.Course;
import org.projectparams.lab2.course.test.model.entities.Attempt;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Student extends User {
    @OneToMany(mappedBy = "student")
    List<Attempt> attempts = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    List<Course> courses = new ArrayList<>();
}
