package org.arpit.java2blog.repository;

import java.util.List;
import java.util.Optional;

import org.arpit.java2blog.model.Student;

public interface StudentRepository{
 
	int save(Student student);

    int update(Student student);

    int deleteById(int id);

    List<Student> findAll();
    
    Optional<Student> findById(Long id);

}