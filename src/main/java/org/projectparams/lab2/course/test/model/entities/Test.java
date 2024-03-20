package org.projectparams.lab2.course.test.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.projectparams.lab2.course.model.entities.Course;
import org.projectparams.lab2.users.model.entities.Student;
import org.projectparams.lab2.users.model.entities.Teacher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NonNull
    @NotBlank
    String name;

    @OneToMany
    @NotEmpty
    Set<Student> allowedStudents = new HashSet<>();

    @OneToMany(mappedBy = "test")
    @ToString.Exclude
    List<Attempt> attempts;

    @NotNull
    @NonNull
    @Positive
    Byte attemptsLimit;

    @NotNull
    @NonNull
    @Positive
    Integer timeLimit;

    @ManyToOne
    @NotNull
    @NonNull
    Teacher teacher;

    @OneToMany
    @NotEmpty
    List<Question> questions;

    @NotNull
    @NonNull
    @ManyToOne
    @ToString.Exclude
    Course course;
}
