package com.test.developer.employeesserver.dto;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class MonthlyEmployee extends Employee {

    public MonthlyEmployee(Employee employee) {
        this.setId(employee.getId());
        this.setName(employee.getName());
        this.setContractTypeName(employee.getContractTypeName());
        this.setRoleId(employee.getRoleId());
        this.setRoleName(employee.getRoleName());
        this.setRoleDescription(employee.getRoleDescription());
        this.setRoleName(employee.getRoleName());
        this.setHourlySalary(employee.getHourlySalary());
        this.setMonthlySalary(employee.getMonthlySalary());
        this.setCalculatedAnnualSalary(getMonthlySalary() * 12);
    }
}
