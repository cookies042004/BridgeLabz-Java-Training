package objectoriented.polymorphism;

import java.util.*;

interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

abstract class Employee implements Department {
    // Encapsulation
    private int employeeId;
    private String name;
    private double baseSalary;
    private String departmentName;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters & Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Interface Implementation
    @Override
    public void assignDepartment(String deptName) {
        this.departmentName = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }

    // Abstract method → will be overridden
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name      : " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println(getDepartmentDetails());
        System.out.println("Calculated Salary: " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private double fixedAllowance;

    public FullTimeEmployee(int id, String name, double baseSalary, double fixedAllowance) {
        super(id, name, baseSalary);
        this.fixedAllowance = fixedAllowance;
        assignDepartment("Full-Time Department");
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedAllowance;
    }
}

class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int workingHours) {
        super(id, name, hourlyRate * workingHours);
        this.hourlyRate = hourlyRate;
        this.workingHours = workingHours;
        assignDepartment("Part-Time Department");
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workingHours;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {

        // Polymorphism - list of Employee references
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new FullTimeEmployee(101, "Akhil", 30000, 5000));
        employeeList.add(new PartTimeEmployee(102, "Riya", 300, 40));

        // Process all employees polymorphically
        for (Employee emp : employeeList) {
            emp.displayDetails();
            System.out.println("-----------------------------");
        }
    }
}

