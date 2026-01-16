package objectoriented.oopsprinciple;

import java.util.ArrayList;

class Order {
    String orderId;
    ArrayList<Product> products = new ArrayList<>();

    Order(String orderId) {
        this.orderId = orderId;
    }

    void addProduct(Product p) {
        products.add(p); // Aggregation: order has products
    }

    void showOrder() {
        System.out.println("\nOrder ID: " + orderId);
        for (Product p : products) {
            p.showProduct();
        }
    }
}

class Product {
    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    void showProduct() {
        System.out.println("- " + productName + " : Rs." + price);
    }
}

class CustomerProduct {
    String customerName;
    ArrayList<Order> orders = new ArrayList<>();

    CustomerProduct(String customerName) {
        this.customerName = customerName;
    }

    void placeOrder(Order o) {
        orders.add(o);
        System.out.println(customerName + " placed Order: " + o.orderId);
    }

    void showOrders() {
        System.out.println("\nOrders for Customer: " + customerName);
        for (Order o : orders) {
            o.showOrder();
        }
    }
}

public class EcommerceSystem {
    public static void main(String[] args) {
        CustomerProduct c1 = new CustomerProduct("Akhil");

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 500);

        Order o1 = new Order("ORD101");
        o1.addProduct(p1);
        o1.addProduct(p2);

        c1.placeOrder(o1);

        c1.showOrders();
    }
}
