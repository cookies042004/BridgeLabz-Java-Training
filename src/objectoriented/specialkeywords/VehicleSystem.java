package objectoriented.specialkeywords;

class Vehicle {
    static double registrationFee = 1500.0;

    final String registrationNumber;
    String ownerName, vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("Rohit", "Car", "REG100");
        v.displayDetails();
    }
}

