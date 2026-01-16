package objectoriented.constructors.level1;

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double pricePerDay = 1500;

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * pricePerDay;
    }

    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

public class CarRentalTest {
    public static void main(String[] args) {
        CarRental rental = new CarRental("Akhil", "Swift", 4);
        rental.display();
    }
}

