package objectOriented.constructors.level1;

class Student {
    public int rollNumber;      // public
    protected String name;      // protected
    private double CGPA;        // private

    // Public getter
    public double getCGPA() {
        return CGPA;
    }

    // Public setter
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber); // public
        System.out.println("Name: " + name);              // protected
        System.out.println("CGPA: " + getCGPA());         // private via method
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent();
        pg.rollNumber = 101;
        pg.name = "Akhil";
        pg.setCGPA(8.5);

        pg.displayDetails();
    }
}

