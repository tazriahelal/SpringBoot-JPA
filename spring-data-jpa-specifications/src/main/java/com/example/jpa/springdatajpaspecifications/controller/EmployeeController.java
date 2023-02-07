package com.example.jpa.springdatajpaspecifications.controller;

import com.example.jpa.springdatajpaspecifications.model.Employee;
import com.example.jpa.springdatajpaspecifications.repository.EmployeeRepository;
import com.example.jpa.springdatajpaspecifications.specifications.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.jpa.springdatajpaspecifications.specifications.EmployeeSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{firstName}/{department}")
    public List<Employee> findByFirstnameAndDepartment(
            @PathVariable("firstName") String firstName,
            @PathVariable("department") String department
    ) {
        return employeeRepository.findAll(where(equalFirstName(firstName)
                .and(EmployeeSpecification.equalDepartment(department))));
    }

    @GetMapping("/{lastName}")
    public List<Employee> findByFirstnameAndDepartment(@PathVariable("lastName") String lastName){
        return employeeRepository.findAll(containsLastName(lastName));
    }
}