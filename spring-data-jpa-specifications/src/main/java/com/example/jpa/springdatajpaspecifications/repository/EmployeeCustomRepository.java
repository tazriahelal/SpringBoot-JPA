package com.example.jpa.springdatajpaspecifications.repository;

import com.example.jpa.springdatajpaspecifications.model.Employee;

import java.util.List;

public interface EmployeeCustomRepository {

    List<Employee> findByFirstNameAndDepartment(String firstname,String department);

}