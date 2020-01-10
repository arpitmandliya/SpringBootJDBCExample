package org.arpit.java2blog;

import java.util.Arrays;
import java.util.List;

import org.arpit.java2blog.model.Student;
import org.arpit.java2blog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcExampleApplication implements CommandLineRunner{

	@Autowired
	StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcExampleApplication.class, args);
	}

	@Override
    public void run(String... args) {
        System.out.println("StartApplication...");
        testStudentData();
    }

    void testStudentData() {

        List<Student> students = Arrays.asList(
                new Student(1,"John", 16),
                new Student(2,"Martin", 18),
                new Student(3,"Mary",  20),
                new Student(4,"Ricky", 15)
        );

        System.out.println("[SAVE]");
        students.forEach(student -> {
            System.out.println("Saving student with name: "+student.getStudentName() );
            studentService.save(student);
        });

        // find all
        System.out.println("get All students: "+studentService.findAll());

        // find by id
        System.out.println("Find Student with id 2");
        Student student = studentService.findById(2L).orElseThrow(IllegalArgumentException::new);
        System.out.println("Student with id 2: "+student);

        // update
        System.out.println("Update age of Martin to 19");
        student.setAge(19);
        System.out.println("Rows affected: "+studentService.update(student));

        // delete
        System.out.println("Delete Student with id 4");
        System.out.println("Rows affected: "+ studentService.deleteById(4));

        // find all
        System.out.println("get updated list of Students: "+studentService.findAll());

    }
}
