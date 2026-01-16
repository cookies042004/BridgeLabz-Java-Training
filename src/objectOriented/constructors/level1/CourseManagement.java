package objectOriented.constructors.level1;

class Course {
    String courseName;
    int duration;
    double fee;

    static String instituteName = "Capgemini"; // class variable

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class CourseManagement {
    public static void main(String[] args) {
        Course c1 = new Course("Java", 8, 15000);
        Course c2 = new Course("Python", 6, 12000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("BridgeLabz");

        System.out.println("\nAfter Updating Institute Name:\n");
        c1.displayCourseDetails();
    }
}

