package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the data ... only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<Student>();

        theStudents.add(new Student("A", "Phan"));
        theStudents.add(new Student("B", "Nguyen"));
        theStudents.add(new Student("C", "Tran"));
        theStudents.add(new Student("D", "Le"));
    }

    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudent(){
        return theStudents;
    }

    //define endpoint for "/students/{studentID}" - return student at index
    @GetMapping("/students/{studentID}")
    public Student getStudentByID(@PathVariable int studentID){

        //check the studentID to throw exception
        if(studentID >= theStudents.size() || studentID < 0){
            throw new StudentNotFoundException("Student id not found - " + studentID);
        }


        return theStudents.get(studentID);  //Happy path
    }



}
