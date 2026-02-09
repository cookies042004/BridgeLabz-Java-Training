package java8features;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " - " + department + " - $" + salary;
    }
}

public class EmployeeProcessing {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "Engineering", 90000),
                new Employee(2, "Alice", "Engineering", 85000),
                new Employee(3, "Bob", "HR", 70000),
                new Employee(4, "Mike", "Engineering", 75000)
        );

        // Filter + Sort
        List<Employee> filtered = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        // Group
        Map<String, List<Employee>> grouped =
                filtered.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        // Average salary per department
        Map<String, Double> avgSalary =
                filtered.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Filtered & Sorted: " + filtered);
        System.out.println("Grouped: " + grouped);
        System.out.println("Average Salary: " + avgSalary);
    }
}
