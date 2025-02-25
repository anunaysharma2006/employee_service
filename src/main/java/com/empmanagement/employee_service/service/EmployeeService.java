package com.empmanagement.employee_service.service;

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

    public void addCompany(Employee emp) {
        repo.save(emp);
    }

    public void updateCompany(Employee emp) {

        repo.save(emp);
    }

    public void deleteProduct(int employeeId) {
        Employee employee = repo.findById(employeeId).orElse(null);
        if (employee != null) {
            repo.delete(employee);
        }
    }

    public Employee getEmployeeDetails(int employeeId) {
        Employee employee = repo.findById(employeeId).orElse(null);
        return employee;

    }
}
