package org.arpit.java2blog.service;

import java.util.List;
import java.util.Optional;

import org.arpit.java2blog.model.Student;

public interface StudentService {

	int save(Student student);

    int update(Student student);

    int deleteById(int id);

    List<Student> findAll();
    
    Optional<Student> findById(Long id);

}
