package generics;


import java.util.*;

// abstract course type
abstract class CourseType {
    String courseName;

    CourseType(String courseName) {
        this.courseName = courseName;
    }

    abstract void evaluate();
}

// different course type
class ExamCourse extends CourseType {

    ExamCourse(String courseName) {
        super(courseName);
    }

    void evaluate() {
        System.out.println(courseName + " evaluated using Final Exam");
    }
}

class AssignmentCourse extends CourseType {

    AssignmentCourse(String courseName) {
        super(courseName);
    }

    void evaluate() {
        System.out.println(courseName + " evaluated using Assignments");
    }
}

class ResearchCourse extends CourseType {

    ResearchCourse(String courseName) {
        super(courseName);
    }

    void evaluate() {
        System.out.println(courseName + " evaluated using Research Work");
    }
}

// generic course manager
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    void addCourse(T course) {
        courses.add(course);
    }

    List<T> getCourses() {
        return courses;
    }
}

// class utility using wildcards
class UniversityUtil {

    static void evaluateAllCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            c.evaluate();
        }
    }
}

public class CourseManagement {
    public static void main(String[] args) {

        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Data Structures"));
        examCourses.addCourse(new ExamCourse("Operating Systems"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Web Development"));
        assignmentCourses.addCourse(new AssignmentCourse("Software Engineering"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research"));

        System.out.println("---- Exam Based Courses ----");
        UniversityUtil.evaluateAllCourses(examCourses.getCourses());

        System.out.println("---- Assignment Based Courses ----");
        UniversityUtil.evaluateAllCourses(assignmentCourses.getCourses());

        System.out.println("---- Research Based Courses ----");
        UniversityUtil.evaluateAllCourses(researchCourses.getCourses());
    }
}

