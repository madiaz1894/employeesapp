package com.test.developer.employeesserver;

import com.test.developer.client.CallRestService;
import com.test.developer.employeesserver.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * This Project is based in Spring
 * because it allows me to consume and provide REST services reducing
 * the boilerplate code using annotations.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.test.developer")
public class EmployeesserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesserverApplication.class, args);
	}

    @Bean
    ApplicationRunner init(EmployeeRepository repository) {
        return args -> {
            repository.saveAll(CallRestService.callRestService());
            repository.findAll().forEach(System.out::println);
        };
    }



}
