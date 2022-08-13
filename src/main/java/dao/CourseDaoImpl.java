package dao;

import model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {


    private static List<Course> courseList = new ArrayList<>();


    @Override
    public Course saveCourse(Course course) {
        courseList.add(course);
        return course;
    }

    @Override
    public Course findById(int Id) {
        for (Course c : courseList) {
            if (c.getId() == Id) {

                return c;
            }

        }
        return null;
    }


    @Override
    public List<Course> findByName(String name) {

        for (Course c : courseList) {
            if (c.getCourseName() == name) {
                return courseList;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {

        List<Course> foundMatches = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getStartDate().equals(date))
                foundMatches.add(c);
        }
        return foundMatches;
    }


    @Override
    public List<Course> findAll() {
        return courseList;
    }

    @Override
    public boolean removeCourse(Course course) {

        Course courseToremove = findById(course.getId());
        if (courseToremove != null)
            courseList.remove(courseToremove);


        return false;


    }
}
