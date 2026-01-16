package objectoriented.specialkeywords;

class Employee {
    static String companyName = "Capgemini";
    static int totalEmployees = 0;

    final int id;
    String name, designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + this.name);
            System.out.println("ID: " + this.id);
            System.out.println("Designation: " + this.designation);
        }
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee e = new Employee("Rahul", 101, "Developer");
        e.displayDetails();
        Employee.displayTotalEmployees();
    }
}

