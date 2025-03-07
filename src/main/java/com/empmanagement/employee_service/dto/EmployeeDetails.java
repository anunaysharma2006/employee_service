package com.empmanagement.employee_service.dto;

import com.empmanagement.employee_service.model.Address;
import com.empmanagement.employee_service.model.Company;
import com.empmanagement.employee_service.model.Employee;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class EmployeeDetails {
    private String firstName;
    private String lastName;
    private  String employeeAddress;
    private int zip;
    private String empAddress;

    @Autowired
    Employee employee;

    @Autowired
    Company company;
    @Autowired
    Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = employee.getFirstName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = employee.getLastName();
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employee.getEmployeeAddress();
    }

    public int getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = address.getZip();
    }


}
