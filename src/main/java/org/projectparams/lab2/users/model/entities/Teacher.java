package org.projectparams.lab2.users.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.projectparams.lab2.schedule.model.entities.Schedule;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Teacher extends User {
    @OneToOne
    @NotNull
    Schedule schedule;
}
