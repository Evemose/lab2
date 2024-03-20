package org.projectparams.lab2.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name = "users")
@Data
public abstract class User {
    @Id
    @GeneratedValue
    protected Long id;
    @NotNull
    @NotBlank
    @Column(unique = true)
    protected String username;
}
