package com.examen.pt1.examen.service;


import com.examen.pt1.examen.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(long id);
}
