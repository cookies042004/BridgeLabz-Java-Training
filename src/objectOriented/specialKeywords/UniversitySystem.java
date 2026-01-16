package objectOriented.specialKeywords;

class Student {
    static String universityName = "Delhi University";
    static int totalStudents = 0;

    final int rollNumber;
    String name, grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + this.name);
            System.out.println("Roll No: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        }
    }
}

    public class UniversitySystem {
    public static void main(String[] args) {
        Student s = new Student("Aman", 101, "A");
        s.displayDetails();
        Student.displayTotalStudents();
    }
}

