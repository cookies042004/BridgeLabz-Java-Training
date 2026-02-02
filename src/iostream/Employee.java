package iostream;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    // constructor calling is done when object is created
    public Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public long displaySerialID(){
        return serialVersionUID;
    }

    // overriding the object-class method
    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}
