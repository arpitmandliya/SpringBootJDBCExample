package org.arpit.java2blog.repository;

import java.util.List;
import java.util.Optional;

import org.arpit.java2blog.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	// Just need to autowire JdbcTemplate, spring boot will
	// do auto configure
    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    @Override
    public int save(Student student) {
        return jdbcTemplate.update(
                "insert into students (studentName, age) values(?,?)",
                student.getStudentName(), student.getAge());
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update(
                "update students set age = ? where id = ?",
                student.getAge(), student.getStudentId());
    }


    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete students where id = ?",
                id);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(
                "select * from student",
                (rs, rowNum) ->
                        new Student(
                                rs.getInt("id"),
                                rs.getString("studentName"),
                                rs.getInt("age")
                        )
        );
    }

    @Override
    public Optional<Student> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from student where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Student(
                                rs.getInt("id"),
                                rs.getString("studentName"),
                                rs.getInt("age")
                        ))
        );
    }
}