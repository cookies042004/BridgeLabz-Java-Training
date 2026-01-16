package objectoriented.polymorphism;

import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;

    private List<String> medicalHistory = new ArrayList<>();

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Manage Records
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + medicalHistory);
    }

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + " | Name: " + name + " | Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {

    public InPatient(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public double calculateBill() {
        return 5000 + (200 * getAge()); // Age-based logic
    }
}

class OutPatient extends Patient {

    public OutPatient(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public double calculateBill() {
        return 1000; // Flat fee
    }
}

public class PatientManagement {
    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        InPatient p1 = new InPatient(1, "Akhil", 25);
        p1.addRecord("Blood Test Normal");

        OutPatient p2 = new OutPatient(2, "Riya", 30);
        p2.addRecord("Flu Symptoms");

        patients.add(p1);
        patients.add(p2);

        for (Patient p : patients) {
            p.getPatientDetails();
            p.viewRecords();
            System.out.println("Bill: ₹" + p.calculateBill());
            System.out.println("-----------------------------");
        }
    }
}
