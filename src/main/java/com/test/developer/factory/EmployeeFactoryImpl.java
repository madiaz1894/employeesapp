package com.test.developer.factory;

import com.test.developer.employeesserver.dto.Employee;
import com.test.developer.employeesserver.dto.HourlyEmployee;
import com.test.developer.employeesserver.dto.MonthlyEmployee;
import com.test.developer.util.Constants;

public class EmployeeFactoryImpl implements EmployeeFactory {

    @Override
    public Employee createEmployeeByType(Employee employee) {
        if (employee.getContractTypeName().equalsIgnoreCase(Constants.HOURLY_CONTRACT)) {
            return new HourlyEmployee(employee);
        } else if (employee.getContractTypeName().equalsIgnoreCase(Constants.MONTHLY_CONTRACT)){
            return new MonthlyEmployee(employee);
        }
        return null;
    }
}
