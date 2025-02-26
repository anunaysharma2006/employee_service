package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.Employee;
import com.empmanagement.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

    @Autowired
    EmployeeService service;
    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {

        service.addEmployee(emp);
        return  new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) {
        service.updateEmployee(emp);
        return  new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int employeeId) {
        service.deleteEmployee(employeeId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        return service.getEmployeeDetails(employeeId);
    }

}
