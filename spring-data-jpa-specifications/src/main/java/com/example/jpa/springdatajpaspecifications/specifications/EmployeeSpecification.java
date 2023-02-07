package com.example.jpa.springdatajpaspecifications.specifications;

import com.example.jpa.springdatajpaspecifications.model.Employee;
import org.springframework.data.jpa.domain.Specification;


public class EmployeeSpecification {


    public static Specification<Employee> equalFirstName(String firstName){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("FIRST_NAME"), firstName);
        });
    }

    public static Specification<Employee> containsLastName(String lastName){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("LAST_NAME"),"%"+ lastName + "%");
        });
    }

    public static Specification<Employee> equalDepartment(String department){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("DEPARTMENT_NAME"), department);
        });
    }
}