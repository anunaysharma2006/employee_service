package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.Employee;
import com.empmanagement.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

    @Autowired
    EmployeeService service;
    @PostMapping
    public void addEmployee(@RequestBody Employee emp) {
        service.addEmployee(emp);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee emp) {
        service.updateEmployee(emp);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        service.deleteEmployee(employeeId);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        return service.getEmployeeDetails(employeeId);
    }

}
