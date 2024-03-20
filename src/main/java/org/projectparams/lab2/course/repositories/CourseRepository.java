package org.projectparams.lab2.course.repositories;

import org.projectparams.lab2.course.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
