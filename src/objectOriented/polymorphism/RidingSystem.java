package objectOriented.polymorphism;

import java.util.ArrayList;
import java.util.List;

// interface
interface GPS{
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// abstract class
abstract class RidingVehicle implements GPS{
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    RidingVehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation){
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public String getVehicleId(){ return vehicleId; }
    public String getDriverName(){ return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Driver Name  : " + driverName);
        System.out.println("Rate per KM  : ₹" + ratePerKm);
        System.out.println("Location     : " + currentLocation);
    }
}

// car class
class RidingCar extends RidingVehicle{
    public RidingCar(String id, String driver, double rate, String location) {
        super(id, driver, rate, location);
    }

    @Override
    public double calculateFare(double distance){
        return getRatePerKm() * distance;
    }
}
// BIKE
class RidingBike extends RidingVehicle {
    public RidingBike(String id, String driver, double rate, String location) {
        super(id, driver, rate, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8; // 20% cheaper
    }
}

// AUTO
class Auto extends RidingVehicle {
    public Auto(String id, String driver, double rate, String location) {
        super(id, driver, rate, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 10; // base charge
    }
}

public class RidingSystem {
    // Polymorphism method
    static void calculateAllFares(List<RidingVehicle> list, double distance) {
        for (RidingVehicle v : list) {
            v.getVehicleDetails();
            double fare = v.calculateFare(distance);
            System.out.println("Fare for " + distance + " km: ₹" + fare);
            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args) {
        List<RidingVehicle> rides = new ArrayList<>();

        rides.add(new RidingCar("CAR001", "Arjun", 15, "Andheri"));
        rides.add(new RidingBike("BIK555", "Ravi", 10, "Bandra"));
        rides.add(new Auto("AUT999", "Suresh", 12, "Dadar"));

        calculateAllFares(rides, 8.5); // Calculate fares for 8.5 km
    }
}
