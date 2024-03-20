package org.projectparams.lab2.course.test.repository;

import org.projectparams.lab2.course.test.model.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
