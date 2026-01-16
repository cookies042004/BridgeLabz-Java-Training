package objectoriented.oopsprinciple;

import java.util.ArrayList;

class Doctor {
    String doctorName;
    ArrayList<Patient> patients = new ArrayList<>();

    Doctor(String doctorName) {
        this.doctorName = doctorName;
    }

    void consult(Patient p) {
        System.out.println("Doctor " + doctorName + " is consulting Patient " + p.patientName);
        patients.add(p);
        p.doctors.add(this);  // both sides know each other
    }

    void showPatients() {
        System.out.println("\nPatients seen by " + doctorName + ":");
        for (Patient p : patients) {
            System.out.println("- " + p.patientName);
        }
    }
}

class Patient {
    String patientName;
    ArrayList<Doctor> doctors = new ArrayList<>();

    Patient(String patientName) {
        this.patientName = patientName;
    }

    void showDoctors() {
        System.out.println("\nDoctors consulted by " + patientName + ":");
        for (Doctor d : doctors) {
            System.out.println("- " + d.doctorName);
        }
    }
}

class Hospital {
    String hospitalName;

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {

        Doctor d1 = new Doctor("Dr. Sharma");
        Doctor d2 = new Doctor("Dr. Mehta");

        Patient p1 = new Patient("Akhil");
        Patient p2 = new Patient("Riya");

        // Consultations (many-to-many)
        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p1);

        // Display associations
        d1.showPatients();
        d2.showPatients();

        p1.showDoctors();
        p2.showDoctors();
    }
}

