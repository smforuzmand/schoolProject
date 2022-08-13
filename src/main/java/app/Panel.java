package app;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import model.Course;
import model.Student;

import java.time.LocalDate;
import java.util.List;

public class Panel {
    static Integer element;

    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        CourseDaoImpl courseDao = new CourseDaoImpl();

        while (true) {

            Application.displayMenu();

            element = Application.getNumberFromUser();
            //Students
            String name = null;
            if (element.equals(1)) {
                System.out.println("You are creating a new student profile!");
                System.out.print("Please insert the student Id:");
                int id = Application.getNumberFromUser();
                System.out.print("Please write the name of student: ");
                name = Application.getStringFromUser();
                System.out.print("Please write the email : ");
                String email = Application.getStringFromUser();
                System.out.print("Please insert the address: ");
                String address = Application.getStringFromUser();
                Student student = new Student(id, name, email, address);
                studentDao.saveStudent(student);
                Application.countinueProgram();

            }

            //Course
            else if (element.equals(2)) {
                System.out.println("You are creating a new course profile!");
                System.out.print("Please insert Id :");
                int id = Application.getNumberFromUser();
                //int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Please write the course name : ");
                String courseName = Application.getStringFromUser();
                System.out.print("Please insert the start date: ");
                LocalDate startDate = LocalDate.parse(Application.getStringFromUser());
                System.out.print("Please insert the duration in weeks: ");
                int weekDuration = Application.getNumberFromUser();
                Course course = new Course(id, courseName, startDate, weekDuration);
                courseDao.saveCourse(course);
                Application.countinueProgram();
            }
            //register a student
            else if (element.equals(3)) {
                System.out.println("You are registering a course for a student");
                System.out.println("Please add the student Id :");
                int studentId = Application.getNumberFromUser();
                System.out.println("Please insert the course Id :");
                int courseId = Application.getNumberFromUser();
                Student student = studentDao.findById(studentId);
                Course course = courseDao.findById(courseId);
                if (student != null) {
                    student.register(course);
                    System.out.println(course.toString());
                }
                Application.countinueProgram();


            }
            //Unregister
            else if (element.equals(4)) {
                System.out.println("You are removing the student from the course");
                System.out.println("Please insert student id :");
                int studentId = Application.getNumberFromUser();
                System.out.println("Please insert the course id");
                int courseId = Application.getNumberFromUser();
                Student student = studentDao.findById(studentId);
                Course course = courseDao.findById(courseId);
                if (student != null) {
                    student.unregister(course);

                }
                Application.countinueProgram();

            }

            //findByIdStudent

            else if (element.equals(5)) {
                System.out.println("You are trying to get Info of a student by Id");
                System.out.println("Please insert the student id");
                int studentId = Application.getNumberFromUser();
                Student student = studentDao.findById(studentId);
                if (student != null) {
                    System.out.println(student.toString());
                }
                Application.countinueProgram();


                //findACourseById
            } else if (element.equals(6)) {
                System.out.println("You are tying to get info of a course by Id");
                System.out.println("Please insert the course Id");
                int courseId = Application.getNumberFromUser();
                Course course = courseDao.findById(courseId);
                if (course != null) {
                    System.out.println(course);
                }
                Application.countinueProgram();

                //findACourseByName
            } else if (element.equals(7)) {
                System.out.println("Your are retrieving a course information");
                System.out.println("Please write the course name : ");
                String courseName = Application.getStringFromUser();
                List<Course> courses = courseDao.findByName(courseName);
                System.out.println(courses.toString());

            } else if (element.equals(8)) {
                System.out.println("you are editing a student profile : ");
                System.out.println("Please insert the student Id : ");
                int id = Application.getNumberFromUser();
                System.out.println("Please insert new name :");
                String newName = Application.getStringFromUser();
                System.out.println("please insert new email :");
                String newEmail = Application.getStringFromUser();
                System.out.println("Please insert new address: ");
                String newAddress = Application.getStringFromUser();
                Student studentEdited = studentDao.findById(id);
                if (studentEdited != null) {
                    studentEdited.setName(newName);
                    studentEdited.setEmail(newEmail);
                    studentEdited.setAddress(newAddress);

                }

            } else if (element.equals(9)) {
                System.out.println("you are editing the course contents :");
                System.out.println("Please insert the course id : ");
                int courseId = Application.getNumberFromUser();
                System.out.println("Please insert new name of courseId :");
                String newCourseName = Application.getStringFromUser();
                System.out.println("Please insert new date for the course : ");
                LocalDate newDate = LocalDate.parse(Application.getStringFromUser());
                System.out.println("Please insert new duration for the course : ");
                int newDuration = Application.getNumberFromUser();
                Course courseEdited = courseDao.findById(courseId);
                if (courseEdited != null) {
                    courseEdited.setCourseName(newCourseName);
                    courseEdited.setCourseDuration(newDuration);
                    courseEdited.setStartDate(newDate);
                }


            } else if (element.equals(0)) {
                System.out.println("See you later! ");
                return;

            }


        }

    }
}