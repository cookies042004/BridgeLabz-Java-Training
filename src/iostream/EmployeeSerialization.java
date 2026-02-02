package iostream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {
    public static void main(String[] args) {
        String file = "employees.dat";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Akhil", "IT", 100000));
        employees.add(new Employee(2, "Singham", "HR", 89000));

        // serialize
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(employees);
            System.out.println("Employees saved successfully");
        }catch(IOException e){
            e.printStackTrace();
        }

        // deserialize
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            List<Employee> list = (List<Employee>) ois.readObject();
            System.out.println("Retrieved Employees:");
            for (Employee e : list) {
                System.out.println(e);
                System.out.println(e.displaySerialID());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
