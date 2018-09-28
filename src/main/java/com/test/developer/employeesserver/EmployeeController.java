package com.test.developer.employeesserver;

import com.test.developer.employeesserver.dto.Employee;
import com.test.developer.employeesserver.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

import static com.test.developer.util.Constants.*;

@RestController
@RequestMapping(EMPLOYEES_ROUTE)
class EmployeeController {

    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(ALL_EMPLOYEES_ROUTE)
    @CrossOrigin(origins = FRONTEND_URL)
    public Collection<Employee> allEmployees() {
        return new ArrayList<>(repository.findAll());
    }

    @GetMapping(EMPLOYEE_BY_ID_ROUTE)
    @CrossOrigin(origins = FRONTEND_URL)
    public Employee getEmployee(@PathVariable(ID_PATH_VARIABLE) long id){
        if (repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }
        return null;
    }


}