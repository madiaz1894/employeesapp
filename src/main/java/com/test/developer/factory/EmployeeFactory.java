package com.test.developer.factory;

import com.test.developer.employeesserver.dto.Employee;

public interface EmployeeFactory {

   public Employee createEmployeeByType(Employee employee);
}
