package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define fields for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employee = query.getResultList();

        //return the result
        return employee;
    }

    @Override
    public Employee findById(int id) {
        //get employee
        Employee employee = entityManager.find(Employee.class, id);

        //return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //save employee
        Employee employee1 = entityManager.merge(employee);

        //return save result
        return employee1;
    }

    @Override
    public void deleteByID(int id) {
        //find employee by id
        Employee employee = entityManager.find(Employee.class, id);

        //remove employee
        entityManager.remove(employee);
    }
}
