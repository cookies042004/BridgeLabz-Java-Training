package objectOriented.specialKeywords;

class Product {
    static double discount = 10.0; // 10%
    final String productID;

    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + this.productID);
            System.out.println("Name: " + this.productName);
            System.out.println("Price: " + this.price);
            System.out.println("Quantity: " + this.quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }
}

public class ShoppingSystem {
    public static void main(String[] args) {
        Product p = new Product("P101", "Laptop", 50000, 1);
        p.displayDetails();

        Product.updateDiscount(15);
        p.displayDetails();
    }
}

