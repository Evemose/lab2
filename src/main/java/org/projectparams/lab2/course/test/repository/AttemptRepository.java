package org.projectparams.lab2.course.test.repository;

import org.projectparams.lab2.course.test.model.entities.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {
    Optional<Attempt> findByClosedIsFalseAndStudent_UsernameAndTest_Id(String username, Long testId);

    int countByStudent_UsernameAndTest_Id(String username, Long testId);
}
