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

//    @GetMapping("/employee")           //FOR SEEING ALL THE COMPANY
//    public List<Employee> getEmployee(@RequestParam(required = false) String name){
//        return  service.getProducts(name);
//    }

    @PostMapping           //FOR POSTING THE COMPANY
    public void addProduct(@RequestBody Employee emp){
        service.addCompany(emp);
    }

    @PutMapping
    public void updateProduct(@RequestBody Employee emp){

        service.updateCompany(emp);

    }

    @DeleteMapping("/{employeeId}")
    public void deleteProduct(@PathVariable int employeeId){
        service.deleteProduct(employeeId);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId){
        return service.getEmployeeDetails(employeeId);
    }

}
