package com.luv2code.cruddemo.dao;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void create(Student student);

    Student findById(int id);

    List<Student> findall();

    List<Student> findByLastName(String lastName);

    void update (Student student);

    void delete (int id);

    int deleteAll();

}
