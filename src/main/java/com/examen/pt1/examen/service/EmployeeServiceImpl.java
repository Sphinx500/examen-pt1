package com.examen.pt1.examen.service;
import com.examen.pt1.examen.exception.ResourceNotFoundException;
import com.examen.pt1.examen.model.Airports;
import com.examen.pt1.examen.model.Employee;
import com.examen.pt1.examen.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        } else{
            throw new ResourceNotFoundException("Record not found whit id: "+ id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> emple = this.employeeRepository.findById(employee.getId());

        if (emple.isPresent()){
            Employee employeeUpdate = emple.get();
            employeeUpdate.setId(employee.getId());
            employeeUpdate.setSurname(employee.getSurname());
            employeeUpdate.setFirstname(employee.getFirstname());

            employeeRepository.save(employeeUpdate);
            return employee;
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ employee.getId());
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);

        if(employee.isPresent()){
            this.employeeRepository.delete(employee.get());
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ id);
        }
    }
}
