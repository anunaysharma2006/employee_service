package com.empmanagement.employee_service.dto;

import lombok.Data;

@Data
public class DashboardEntityCount {
    Long userCount;
    Long employeeCount;
    Long companyCount;
    Long addressCount;
}
