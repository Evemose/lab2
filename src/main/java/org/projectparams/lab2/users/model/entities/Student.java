package org.projectparams.lab2.users.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.projectparams.lab2.course.test.model.entities.Attempt;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Student extends User {
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    List<Attempt> attempts = new ArrayList<>();
}
