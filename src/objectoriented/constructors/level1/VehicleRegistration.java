package objectoriented.constructors.level1;

class Vehicle {
    String ownerName;
    String vehicleType;

    static double registrationFee = 2500; // class variable

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Akhil", "Car");
        Vehicle v2 = new Vehicle("Ravi", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(3000);

        System.out.println("\nAfter Fee Update:\n");
        v1.displayVehicleDetails();
    }
}

