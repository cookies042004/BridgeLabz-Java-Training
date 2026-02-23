package designpatterns;

interface Car{
    void drive();
}

interface Bike{
    void ride();
}

// Car Implementations
class Sedan implements Car {
    public void drive() {
        System.out.println("Driving Sedan");
    }
}

class SUV implements Car {
    public void drive() {
        System.out.println("Driving SUV");
    }
}

// Bike Implementations
class SportsBike implements Bike {
    public void ride() {
        System.out.println("Riding Sports Bike");
    }
}

class NormalBike implements Bike {
    public void ride() {
        System.out.println("Riding Normal Bike");
    }
}

// Abstract Factory
interface VehicleFactory{
    Car createCar();
    Bike createBike();
}

// Concrete Factories
class CarFactory implements VehicleFactory {
    public Car createCar() {
        return new Sedan();
    }
    public Bike createBike() {
        return null;
    }
}

class BikeFactory implements VehicleFactory {
    public Car createCar() {
        return null;
    }
    public Bike createBike() {
        return new SportsBike();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        VehicleFactory factory = new CarFactory();
        Car car = factory.createCar();
        car.drive();

        factory = new BikeFactory();
        Bike bike = factory.createBike();
        bike.ride();
    }
}
