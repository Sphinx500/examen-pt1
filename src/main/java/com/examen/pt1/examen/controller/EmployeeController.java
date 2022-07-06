package com.examen.pt1.examen.controller;

import com.examen.pt1.examen.exception.Message;
import com.examen.pt1.examen.model.Employee;
import com.examen.pt1.examen.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/listaemployee")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> lista = employeeService.getAllEmployee();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Message("Sin productos en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @GetMapping("/detalleemployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }


    @PutMapping("/actualizemployee/{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/eliminaemployee/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id){
        this.employeeService.deleteEmployee(id);
        return  HttpStatus.OK;
    }

    @PostMapping("apiv1/clientes/add")
    public  ResponseEntity<Employee> addEmploye(@RequestBody Employee employee){
        return ResponseEntity.ok().body(this.employeeService.addEmployee(employee));
    }
}
