package objectOriented.polymorphism;

import java.util.*;

// interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// abstract class
abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void getItemDetails() {
        System.out.println(itemName + " | Price: " + price + " | Qty: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

// veg-item class
class VegItem extends FoodItem {

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() { return "Veg Discount: 5%"; }
}

// non-veg-item class
class NonVegItem extends FoodItem {

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 20; // Extra charge
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.02; // 2% discount
    }

    @Override
    public String getDiscountDetails() { return "Non-Veg Discount: 2%"; }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Tikka", 150, 2));
        order.add(new NonVegItem("Chicken Biryani", 200, 1));

        for (FoodItem f : order) {
            f.getItemDetails();
            double total = f.calculateTotalPrice();
            double discount = f.applyDiscount();
            System.out.println(f.getDiscountDetails());
            System.out.println("Total: " + total + " | After Discount: " + (total - discount));
            System.out.println("--------------------------------");
        }
    }
}
