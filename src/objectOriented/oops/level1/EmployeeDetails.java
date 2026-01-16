package objectOriented.oops.level1;

class Employee{
    String name = "Akhil Puri";
    int id = 1;
    double salary = 33235.90;

    // method for displaying details
    void displayDetails(){
        System.out.println("Name is " + name + " id is " + id + " salary is " + salary);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        // creating object from employee class
        Employee e = new Employee();

        // calling display method
        e.displayDetails();
    }
}
