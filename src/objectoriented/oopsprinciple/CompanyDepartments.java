package objectoriented.oopsprinciple;

import java.util.ArrayList;

class Employee{
    String name,role;

    Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

    void showEmployee(){
        System.out.println("Employee : " + name + " , Role : " + role);
    }
}

class Department{
    String deptName;

    // creating list for adding employee
    ArrayList<Employee> employee = new ArrayList<>();
    Department(String deptName){
        this.deptName = deptName;
    }

    // adding employee by creating object of it
    void addEmployee(String name, String role){
        employee.add(new Employee(name,role));
    }

    void showDepartment(){
        System.out.println("\nDepartment : " + deptName);
        for(Employee e : employee){
            e.showEmployee();
        }
    }
}

class Company{
    String CompanyName;

    // using list for storing department
    ArrayList<Department> department = new ArrayList<>();

    Company(String CompanyName){
        this.CompanyName = CompanyName;
    }

    // adding department to the list with creating object, which shows the composition property of it
    void addDepartment(String deptName){
        department.add(new Department(deptName));
    }

    Department getDepartment(String deptName){
        for(Department d : department){
            if(d.deptName.equals(deptName)){
                return d;
            }
        }

        return null;
    }

    void showCompany(){
        System.out.println("\nCompany " + CompanyName);
        for(Department d : department){
            d.showDepartment();
        }
    }

    void deleteCompany(){
        System.out.println("\nClosing Company : " + CompanyName);
        department.clear();
        System.out.println("All department and employees details are deleted");
    }
}

public class CompanyDepartments {
    public static void main(String[] args) {
        Company capgemini = new Company("Capgemini");

        capgemini.addDepartment("analyst");

        capgemini.addDepartment("hr");

        Department analyst = capgemini.getDepartment("analyst");
        Department hr = capgemini.getDepartment("hr");

        analyst.addEmployee("Akhil Puri","developer");
        hr.addEmployee("Tej Singh", "hiring manger");

        capgemini.showCompany();

        System.out.println("Before Closing");
        capgemini.deleteCompany();

        System.out.println("After Closing");
        capgemini.showCompany();
    }
}
