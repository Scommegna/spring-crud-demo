package com.sco.cruddemo;

import com.sco.cruddemo.dao.StudentDAO;
import com.sco.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);
            
           // readStudent(studentDAO);
            
            queryForStudents(studentDAO);
        };
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for(Student s : students) System.out.println(s);
    }

    private void readStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Daffy", "Duck", "daffy@email.com");

        studentDAO.save(tempStudent);

        int studentId = tempStudent.getId();

        Student student = studentDAO.findById(studentId);

        System.out.println(student);
    }

    private void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Lucas", "Scommegna", "email@example.com");

        studentDAO.save(tempStudent);
    }

    public void createMultipleStudents(StudentDAO studentDAO) {

    }
}
