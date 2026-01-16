package objectoriented.specialkeywords;

class Patient {
    static String hospitalName = "Apollo Hospital";
    static int totalPatients = 0;

    final int patientID;
    String name, ailment;
    int age;

    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + this.patientID);
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
        }
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient p = new Patient(201, "Kiran", 30, "Fever");
        p.displayDetails();
        Patient.getTotalPatients();
    }
}

