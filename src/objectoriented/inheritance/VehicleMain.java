package objectoriented.inheritance;

class VehicleHybrid {
    int maxSpeed;
    String fuelType;

    VehicleHybrid(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + ", Fuel: " + fuelType);
    }
}

class Car extends VehicleHybrid {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends VehicleHybrid {
    int loadCapacity;

    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends VehicleHybrid {
    boolean hasABS;

    Motorcycle(int maxSpeed, String fuelType, boolean hasABS) {
        super(maxSpeed, fuelType);
        this.hasABS = hasABS;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("ABS: " + hasABS);
    }
}

public class VehicleMain {
    public static void main(String[] args) {

        VehicleHybrid[] vehicles = {
                new Car(180, "Petrol", 5),
                new Truck(120, "Diesel", 12),
                new Motorcycle(150, "Petrol", true)
        };

        for (VehicleHybrid v : vehicles) {
            v.displayInfo();
        }
    }
}

