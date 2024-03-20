package org.projectparams.lab2.schedule.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
public class ScheduleTask implements Comparable<ScheduleTask> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @NotBlank
    protected String name;
    @NotBlank
    protected String description;
    @NotNull
    protected LocalDateTime start;
    @NotNull
    protected Duration duration;

    @Override
    public int compareTo(ScheduleTask o) {
        return start.compareTo(o.start);
    }
}
