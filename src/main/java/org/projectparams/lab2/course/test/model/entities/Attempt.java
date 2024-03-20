package org.projectparams.lab2.course.test.model.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.projectparams.lab2.users.model.Student;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @NotNull
    @NonNull
    Student student;

    @ManyToOne
    @NotNull
    @NonNull
    Test test;

    @ElementCollection
    Map<Question, AnswerOption> answers;

    boolean closed = false;

    @CreatedDate
    LocalDateTime startedAt;

    @Positive
    @Nullable
    Integer duration;

    @Positive
    @Nullable
    Double score;
}
