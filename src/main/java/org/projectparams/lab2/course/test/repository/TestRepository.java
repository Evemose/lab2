package org.projectparams.lab2.course.test.repository;

import org.projectparams.lab2.course.test.model.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}