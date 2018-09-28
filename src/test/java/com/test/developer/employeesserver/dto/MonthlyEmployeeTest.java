package com.test.developer.employeesserver.dto;

import com.test.developer.factory.EmployeeFactory;
import com.test.developer.factory.EmployeeFactoryImpl;
import org.junit.Test;


import static com.test.developer.util.Constants.MONTHLY_CONTRACT;
import static org.junit.Assert.*;

public class MonthlyEmployeeTest {
    @Test
    public void testCalculateAnnualSalary(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setContractTypeName(MONTHLY_CONTRACT);
        employee.setHourlySalary(20000);
        employee.setMonthlySalary(10000);
        EmployeeFactory factory = new EmployeeFactoryImpl();
        Employee employeeResult = factory.createEmployeeByType(employee);
        assertEquals(120000, (int) (employeeResult.getCalculatedAnnualSalary()));
    }

}