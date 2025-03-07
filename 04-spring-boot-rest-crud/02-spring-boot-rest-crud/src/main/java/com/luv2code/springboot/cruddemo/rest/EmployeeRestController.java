package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping  for GET /employees/{employeeID}
    @GetMapping("/employees/{employeeID}")
    public Employee findByID(@PathVariable int employeeID){
        Employee dbEmployee = employeeService.findById(employeeID);
        if(dbEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeID);
        }

        return dbEmployee;
    }

    //add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        //also just in case they pass ian id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update

        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    //add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    //add mapping for DELETE /employees/{employeeID} - delete employee
    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){

        Employee tempEmploye = employeeService.findById(employeeID);

        //throw excetption if null
        if(tempEmploye == null){
            throw new RuntimeException("Employee id not found: " + employeeID);
        }

        employeeService.deleteByID(employeeID);
        return "Deleted employee with ID: " + employeeID;

    }
}
