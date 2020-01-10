package org.arpit.java2blog.service;

import java.util.List;
import java.util.Optional;

import org.arpit.java2blog.model.Student;
import org.arpit.java2blog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	public int save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public int update(Student student) {
		return studentRepository.update(student);
	}

	@Override
	public int deleteById(int id) {
		return studentRepository.deleteById(id);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

}
