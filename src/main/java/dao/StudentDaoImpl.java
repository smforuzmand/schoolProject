package dao;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> students = new ArrayList<>();


    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student s : students) {
            if (s.getEmail().equals(email)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> matchCase = new ArrayList<>();

        for (Student s : students)
            if (s.getName().equals(name)) {
                matchCase.add(s);
            }


        return matchCase;

    }

    @Override
    public Student findById(int Id) {
        for (Student s : students)
            if (s.getId() == Id)
                return s;

        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        Student s = findById(student.getId());
        if (s.getName() != null) {
            students.remove(s);


        }
        return false;
    }
}
