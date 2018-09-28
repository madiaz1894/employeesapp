package com.test.developer.employeesserver.repository;

import com.test.developer.employeesserver.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import static com.test.developer.util.Constants.FRONTEND_URL;


@RepositoryRestResource
@CrossOrigin(origins = FRONTEND_URL)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
