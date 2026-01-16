package objectoriented.oopsprinciple;

import java.util.ArrayList;

class CourseU2 {
    String courseName;
    Professor professor;
    ArrayList<StudentU2> enrolledStudents = new ArrayList<>();

    CourseU2(String courseName) {
        this.courseName = courseName;
    }

    void assignProfessor(Professor p) {
        professor = p;
        System.out.println("Professor " + p.profName + " assigned to " + courseName);
    }

    void enroll(StudentU2 s) {
        enrolledStudents.add(s);
        System.out.println(s.studentName + " enrolled in " + courseName);
    }

    void showCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + professor.profName);
        System.out.println("Students:");
        for (StudentU2 s : enrolledStudents) {
            System.out.println("- " + s.studentName);
        }
    }
}


class StudentU2 {
    String studentName;
    ArrayList<CourseU2> myCourses = new ArrayList<>();

    StudentU2(String studentName) {
        this.studentName = studentName;
    }

    void enrollCourse(CourseU2 c) {
        myCourses.add(c);
        c.enroll(this);
    }
}

class Professor {
    String profName;

    Professor(String profName) {
        this.profName = profName;
    }
}

public class UniversitySystemU2 {
    public static void main(String[] args) {
        StudentU2 s1 = new StudentU2("Akhil");
        StudentU2 s2 = new StudentU2("Priya");

        Professor p1 = new Professor("Dr. Sharma");

        CourseU2 c1 = new CourseU2("Operating Systems");

        c1.assignProfessor(p1);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);

        c1.showCourseDetails();
    }
}

