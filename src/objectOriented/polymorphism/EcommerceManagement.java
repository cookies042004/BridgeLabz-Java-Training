package objectOriented.polymorphism;

import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product implements Taxable {

    // Encapsulation - private fields
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Setters (Controlled updates)
    public void setPrice(double price) { this.price = price; }
    public void setName(String name) { this.name = name; }

    // Abstract method → subclasses must implement
    abstract double calculateDiscount();

    // Common method for all products
    public void displayDetails() {
        System.out.println("Product ID : " + productId);
        System.out.println("Product Name : " + name);
        System.out.println("Price : ₹" + price);
    }
}

class Electronics extends Product {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics GST: 18%";
    }
}

class Clothing extends Product {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing GST: 5%";
    }
}

class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.02; // 2% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.00; // No GST
    }

    @Override
    public String getTaxDetails() {
        return "Groceries: No Tax";
    }
}

public class EcommerceManagement {

    // Method using POLYMORPHISM to print final price
    static void printFinalPrice(List<Product> products) {
        for (Product p : products) {
            p.displayDetails();
            System.out.println(p.getTaxDetails());

            double discount = p.calculateDiscount();
            double tax = p.calculateTax();
            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Discount : ₹" + discount);
            System.out.println("Tax      : ₹" + tax);
            System.out.println("Final Price : ₹" + finalPrice);
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {

        // Polymorphism → list of parent class Product
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "T-Shirt", 1200));
        products.add(new Groceries(103, "Rice Bag 25kg", 1500));

        printFinalPrice(products);
    }
}
