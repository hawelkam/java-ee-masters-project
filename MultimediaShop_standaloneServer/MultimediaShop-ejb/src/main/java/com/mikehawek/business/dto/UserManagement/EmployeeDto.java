package com.mikehawek.business.dto.UserManagement;

public class EmployeeDto extends UserDto {
    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
