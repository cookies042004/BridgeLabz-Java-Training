package objectOriented.oopsPrinciple;

import java.util.ArrayList;

class Course{
    String courseName;
    ArrayList<Student> enrolledStudent = new ArrayList<>();

    Course(String courseName){
        this.courseName = courseName;
    }

    void enrollStudent(Student s){
        enrolledStudent.add(s);
    }

    void showEnrolledStudents() {
        System.out.println("\nStudents enrolled in course: " + courseName);
        for (Student s : enrolledStudent) {
            System.out.println("- " + s.name);
        }
    }
}

class Student{
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name){
        this.name = name;
    }

    void enrollInCourse(Course c) {
        courses.add(c);
        c.enrollStudent(this);   // Association: both sides know each other
    }

    void showCourses() {
        System.out.println("\nCourses for student: " + name);
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class School{
    String schoolName;
    ArrayList<Student> students = new ArrayList<>();

    School(String schoolName){
        this.schoolName = schoolName;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("\nStudents in school: " + schoolName);
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

public class SchoolStudents {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        // Students also exist independently (Aggregation)
        Student akhil = new Student("Akhil");
        Student Priya = new Student("Priya");

        // Adding students to school
        school.addStudent(akhil);
        school.addStudent(Priya);

        // Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Association: Students ↔ Courses (Many-to-Many)
        akhil.enrollInCourse(math);
        akhil.enrollInCourse(science);

        Priya.enrollInCourse(math);

        // Show data
        akhil.showCourses();
        Priya.showCourses();

        math.showEnrolledStudents();
        science.showEnrolledStudents();

        school.showStudents();
    }
}
