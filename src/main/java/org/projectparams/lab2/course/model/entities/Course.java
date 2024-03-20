package org.projectparams.lab2.course.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.projectparams.lab2.course.article.model.entities.Article;
import org.projectparams.lab2.course.test.model.entities.Test;
import org.projectparams.lab2.users.model.Student;
import org.projectparams.lab2.users.model.Teacher;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "course")
    List<Test> tests = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Teacher> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    List<Article> articles = new ArrayList<>();

}
