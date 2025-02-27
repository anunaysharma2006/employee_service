package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.advisor.EntityObjectNotFoundException;
import com.empmanagement.employee_service.model.Employee;
import com.empmanagement.employee_service.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo repo;

    public List<Employee> getProducts(String name) {
        List<Employee> all = repo.findAll();
        return all;
    }

    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    public Employee updateEmployee(Employee emp) {
        return repo.save(emp);
    }

    public Employee deleteEmployee(int employeeId) {
        Employee employee = repo.findById(employeeId).orElse(null);
        if (employee != null) {
            repo.delete(employee);
            return employee;
        }
        else {
            return employee;
        }
    }

    public Employee getEmployeeDetails(int employeeId) {
        Employee employee = repo.findById(employeeId).orElse(null);
        return employee;
    }
}
