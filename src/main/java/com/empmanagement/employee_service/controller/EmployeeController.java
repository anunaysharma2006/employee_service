package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.dto.EmployeeDetails;
import com.empmanagement.employee_service.model.Employee;
import com.empmanagement.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        return new ResponseEntity<>(service.addEmployee(emp), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        return new ResponseEntity<>(service.updateEmployee(emp), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int employeeId) {
        return new ResponseEntity<>(service.deleteEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable int employeeId) {
        return new ResponseEntity<>(service.getEmployeeDetails(employeeId), HttpStatus.ACCEPTED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() {
        return new ResponseEntity<>(service.getEmployees(), HttpStatus.OK);
    }


}
