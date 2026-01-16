package objectOriented.polymorphism;

import java.util.ArrayList;
import java.util.List;

// interface
interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}

// abstract class
abstract class Vehicle implements Insurable{
    private String vehicleNumber;
    private String vehicleType;
    private double rentalRate;

    private String insurancePolicyNumber;

    Vehicle(String vehicleNumber, String vehicleType, double rentalRate, String insurancePolicyNumber){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    // getter function
    public String getVehicleType(){
        return vehicleType;
    }

    public double getRentalRate(){
        return rentalRate;
    }

    // getting policy partial number
    public String getInsurancePolicyNumber(){
        return "Policy number is *****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    // abstract method
    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type         : " + vehicleType);
        System.out.println("Rental Rate  : ₹" + rentalRate + " per day");
        System.out.println(getInsuranceDetails());
    }
}

// car
class Car extends Vehicle{
    public Car(String vehicleNumber, double rentalRate, String insuranceNumber){
        super(vehicleNumber, "Car", rentalRate, insuranceNumber);
    }

    @Override
    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance | " + getInsurancePolicyNumber();
    }
}

// bike
class Bike extends Vehicle {

    public Bike(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Bike", rentalRate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // 20% cheaper
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance | " + getInsurancePolicyNumber();
    }
}

// truck
class Truck extends Vehicle {

    public Truck(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Truck", rentalRate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 2000; // Extra heavy-load fee
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance | " + getInsurancePolicyNumber();
    }
}

public class VehicleRental {
    static void processRentals(List<Vehicle> vehicles, int days) {
        for (Vehicle v : vehicles) {
            v.displayDetails();

            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = v.calculateInsurance();
            double totalCost = rentalCost + insuranceCost;

            System.out.println("Rental Cost for " + days + " days : ₹" + rentalCost);
            System.out.println("Insurance Cost                 : ₹" + insuranceCost);
            System.out.println("Total Cost                     : ₹" + totalCost);
            System.out.println("------------------------------------------");
        }
    }

    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();

        list.add(new Car("CAR1234", 2000, "POLICYCAR9988"));
        list.add(new Bike("BIKE5566", 800, "POLICYBIKE1122"));
        list.add(new Truck("TRUCK9090", 5000, "POLICYTRUCK7788"));

        processRentals(list,5);
    }
}
