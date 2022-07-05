package com.examen.pt1.examen.repository;

import com.examen.pt1.examen.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
