package extrapractice;

import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> priceMap = new HashMap<>();
        priceMap.put("Laptop", 70000.0);
        priceMap.put("Phone", 30000.0);
        priceMap.put("Headphones", 2000.0);

        Map<String, Double> cart = new LinkedHashMap<>();
        cart.put("Phone", priceMap.get("Phone"));
        cart.put("Laptop", priceMap.get("Laptop"));
        cart.put("Headphones", priceMap.get("Headphones"));

        System.out.println("Cart (Insertion Order):");
        cart.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nItems sorted by price:");
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Double> e : cart.entrySet()) {
            sortedByPrice.put(e.getValue(), e.getKey());
        }

        sortedByPrice.forEach((k, v) ->
                System.out.println(v + " -> " + k)
        );
    }
}

