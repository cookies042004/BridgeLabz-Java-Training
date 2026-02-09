package java8features;

import java.util.*;
import java.util.stream.*;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double revenue;

    ProductSales(String productId, double revenue) {
        this.productId = productId;
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return productId + " - $" + revenue;
    }
}

public class SalesAnalysis {
    public static void main(String[] args) {

        List<Sale> sales = Arrays.asList(
                new Sale("P1", 20, 50),
                new Sale("P2", 5, 100),
                new Sale("P3", 15, 30)
        );

        List<ProductSales> topProducts =
                sales.stream()
                        .filter(s -> s.quantity > 10)
                        .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                        .sorted(Comparator.comparing(ps -> ps.revenue, Comparator.reverseOrder()))
                        .limit(5)
                        .collect(Collectors.toList());

        System.out.println(topProducts);
    }
}
