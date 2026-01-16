package objectoriented.oops.level2;

class Student{
    String name;
    int rollNumber;
    int marks;

    // method for calculating garde based on the marks
    char grade(){
        if(marks >= 90) return 'A';
        else if(marks >= 75) return 'B';
        else if(marks >= 60) return 'C';
        else if(marks >= 33) return 'D';
        else return 'F';
    }

    // method for displaying details
    void displayDetails(){
        System.out.println("Name : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Marks : " + marks);
        System.out.println("Grade : " + grade());
    }
}

public class StudentReport {
    public static void main(String[] args) {
        // creating object of class Student
        Student s = new Student();

        // assigning values
        s.name = "Akhil Puri";
        s.rollNumber = 10;
        s.marks = 90;

        // calling display method
        s.displayDetails();
    }
}
