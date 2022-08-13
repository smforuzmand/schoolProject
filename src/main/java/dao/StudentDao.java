package dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    Student saveStudent(Student student);

    Student findByEmail(String email);

    List<Student> findByName(String name);

    Student findById(int Id);

    List<Student> findAll();

    boolean deleteStudent(Student student);

}
