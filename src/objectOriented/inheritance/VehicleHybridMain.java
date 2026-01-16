package objectOriented.inheritance;

class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

// Interface
interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging. Battery: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int tankCapacity;

    PetrolVehicle(int maxSpeed, String model, int tankCapacity) {
        super(maxSpeed, model);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Tank Capacity: " + tankCapacity + " liters");
    }
}

public class VehicleHybridMain {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(160, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(180, "Honda City", 40);

        ev.charge();
        pv.refuel();
    }
}

