package org.projectparams.lab2.schedule.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.projectparams.lab2.users.model.entities.Teacher;

import java.util.SortedSet;

@Entity
@Data
public class Schedule {
    @Id
    private Long id;

    @OneToOne(mappedBy = "schedule")
    @NotNull
    @ToString.Exclude
    Teacher teacher;

    @OneToMany
    SortedSet<ScheduleTask> tasks;
}
