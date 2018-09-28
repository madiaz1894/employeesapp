package com.test.developer.client;

import com.test.developer.employeesserver.dto.Employee;
import com.test.developer.factory.EmployeeFactory;
import com.test.developer.factory.EmployeeFactoryImpl;
import com.test.developer.util.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CallRestService {

    public static List<Employee> callRestService() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                Constants.URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>(){});
        EmployeeFactory employeeFactory = new EmployeeFactoryImpl();

        List<Employee> employees = response
                .getBody()
                .stream()
                .map(employee -> employeeFactory.createEmployeeByType(employee))
                .collect(Collectors.toList());

        return employees;

    }

}
