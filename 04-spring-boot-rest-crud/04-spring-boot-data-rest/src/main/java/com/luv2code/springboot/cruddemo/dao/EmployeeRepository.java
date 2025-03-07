package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members") //now the URL will turn from: http://localhost:8080/magic-api/employees to http://localhost:8080/magic-api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
