package org.projectparams.lab2.course.test.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String question;
    @ElementCollection
    List<AnswerOption> answerOptions;
}
