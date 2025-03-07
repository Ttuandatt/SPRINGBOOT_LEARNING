package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import jdk.internal.opt.CommandLine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			queryForStudents(studentDAO);

			//findStudentByLastName(studentDAO);

			//updateStudents(studentDAO);

			deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.print("Deleted rows count: " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		//delete student
		System.out.print("Type the id of the the student you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		int id = Integer.parseInt(scanner.nextLine());
		studentDAO.delete(id);
		System.out.println("Student with id " + id + " deleted.");

		//display the lst of students
		List<Student> newListOfStudents = studentDAO.findall();
		for (Student student : newListOfStudents) {
			System.out.println(student);
		}

	}

	private void updateStudents(StudentDAO studentDAO) {

		//retrieve student base on the id: primary key
		System.out.print("Type the student id: ");
		Scanner scanner = new Scanner(System.in);
		int id = Integer.parseInt(scanner.nextLine().trim().toLowerCase());
		Student foundStudent = studentDAO.findById(id);
		System.out.println("Student found: " + foundStudent);

		//change first name to "Scott"
		System.out.print("Type the new first name: ");
		String newFirstName = scanner.nextLine().trim();
		foundStudent.setFirstName(newFirstName);

		//update the student
		studentDAO.update(foundStudent);

		//display the updated student
		System.out.println("Student first name after update: " + foundStudent);

	}

	private void findStudentByLastName(StudentDAO studentDAO) {

		System.out.print("Type the last name: ");
		Scanner scanner = new Scanner(System.in);
		String lastName = scanner.nextLine();
		lastName = lastName.trim().toLowerCase();

		//query for students
		List<Student> queriedStudents = studentDAO.findByLastName(lastName);

		//dislpay queried students
		for (Student student : queriedStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//query for students
		List<Student> queriedStudents = studentDAO.findall();

		//display students
		for(Student student : queriedStudents){
			System.out.println(student);
		}
	}

	public void readStudent(StudentDAO studentDAO){

		//create a student object
		System.out.println("Creating new student obejct ...");
		Student student = new Student("Daffy", "Duck", "daffy@gmail.com");

		//save the student
		System.out.println("Saving student ...");
		studentDAO.create(student);

		//display id of the new saved student
		int theID = student.getID();
		System.out.println("Saved student. Generated id: " + theID);

		//retrieve student base on the id: primary key
		System.out.println("Retrieving student with id: " + theID);
		Student retrievedStudent = studentDAO.findById(theID);

		//display student
		System.out.println("Student found: " + retrievedStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating 4 student objects ...");
		Student student1 = new Student("A", "Nguyen", "A@gmail.com");
		Student student2 = new Student("B", "Tran", "B@gmail.com");
		Student student3 = new Student("C", "Trinh", "C@gmail.com");
		Student student4 = new Student("D", "Tran", "D@gmail.com");

		//save the student object
		System.out.println("Saving student objects ...");
		studentDAO.create(student1);
		studentDAO.create(student2);
		studentDAO.create(student3);
		studentDAO.create(student4);

		System.out.println("Done!");
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object ...");
		Student student1 = new Student("Danny", "Phan", "Danny@gmail.com");
		Student student2 = new Student("Emily", "Son", "Emily@gmail.com");

		//save the student object
		System.out.println("Saving student object ...");
		studentDAO.create(student1);
		studentDAO.create(student2);

		//display id of the saved student
		System.out.println("Saved student object!. Generated id: " + student1.getID()+"\n");
		System.out.println("Saved student object!. Generated id: " + student2.getID()+"\n");


	}

}
