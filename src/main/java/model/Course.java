package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int courseDuration;
    private List<Student> students ;



    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.courseDuration = weekDuration;
        students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void register(Student student) {
        if (student!=null)
        students.add(student);
        students.remove(student);
    }

    public void unregister(Student student) {

        if (student != null) {
            students.remove(student);
        }

    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + courseDuration +
                ", students=" + students +
                '}';
    }
}
