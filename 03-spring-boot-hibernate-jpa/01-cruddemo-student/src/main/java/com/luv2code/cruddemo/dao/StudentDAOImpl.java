package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //supports component scanning, translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO {

    //////////////////////////// NOTES ///////////////////////////////////////////
    // 1. @Transactional: dùng khi thực hiện các truy vấn kiểu update           //
    // 2. Create: dùng phương thức .persist(arg)                                //
    // 3. Read: xem các phương thức findByID, findByLastName, findAll để biết cụ//
    //          thể hơn                                                         //
    // 4. Update: dùng phương thức.merge(arg)                                   //
    // 5. Delete: xem các phương thức delete, deleteAll để biết cụ thể hơn      //
    //////////////////////////////////////////////////////////////////////////////



    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method


    @Override
    @Transactional
    public void create(Student student) {
        entityManager.persist(student); //saves the student
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findall() {

        //create query
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);       //Student here is not the database table, it's the entity name aka the class name

        //return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        //create query
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        //set parameter
        query.setParameter("theData", lastName);
        //return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        //update
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {

        //retrieve the student
        Student student = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberOfRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numberOfRowsDeleted;
    }
}


