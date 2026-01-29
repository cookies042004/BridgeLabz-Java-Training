package extrapractice;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicySystem {
    public static void main(String[] args) {

        Map<Integer, Policy> hashMap = new HashMap<>();
        Map<Integer, Policy> linkedHashMap = new LinkedHashMap<>();

        // TreeMap sorted by expiry date
        TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();

        Policy p1 = new Policy(101, "Akhil",
                LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy(102, "Rahul",
                LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy(103, "Akhil",
                LocalDate.now().minusDays(5), "Home", 8000);

        addPolicy(hashMap, linkedHashMap, treeMap, p1);
        addPolicy(hashMap, linkedHashMap, treeMap, p2);
        addPolicy(hashMap, linkedHashMap, treeMap, p3);

        System.out.println("Retrieve policy 101:");
        System.out.println(hashMap.get(101));

        System.out.println("\nPolicies expiring in next 30 days:");
        listExpiringSoon(hashMap);

        System.out.println("\nPolicies for policyholder Akhil:");
        listByHolder(hashMap, "Akhil");

        System.out.println("\nRemoving expired policies...");
        removeExpired(hashMap);

        System.out.println("\nRemaining Policies:");
        hashMap.values().forEach(System.out::println);
    }

    static void addPolicy(Map<Integer, Policy> hashMap,
                          Map<Integer, Policy> linkedHashMap,
                          Map<LocalDate, Policy> treeMap,
                          Policy p) {
        hashMap.put(p.policyNumber, p);
        linkedHashMap.put(p.policyNumber, p);
        treeMap.put(p.expiryDate, p);
    }

    static void listExpiringSoon(Map<Integer, Policy> map) {
        LocalDate today = LocalDate.now();
        for (Policy p : map.values()) {
            if (!p.expiryDate.isBefore(today) &&
                    p.expiryDate.isBefore(today.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    static void listByHolder(Map<Integer, Policy> map, String name) {
        for (Policy p : map.values()) {
            if (p.policyHolderName.equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    static void removeExpired(Map<Integer, Policy> map) {
        map.entrySet().removeIf(
                e -> e.getValue().expiryDate.isBefore(LocalDate.now())
        );
    }
}

