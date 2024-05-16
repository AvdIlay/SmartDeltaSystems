package org.example.smartdeltasystems.repository;

import org.example.smartdeltasystems.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
