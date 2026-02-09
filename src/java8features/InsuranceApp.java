package java8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class InsurancePolicy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public String toString() {
        return "Policy No: " + policyNumber +
                ", Holder: " + holderName +
                ", Premium: $" + premiumAmount;
    }
}

public class InsuranceApp {
    public static void main(String[] args) {

        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P101", "John Smith", 1500),
                new InsurancePolicy("P102", "Alice Brown", 900),
                new InsurancePolicy("P103", "Michael Johnson", 2200),
                new InsurancePolicy("P104", "Anna Smith", 1800),
                new InsurancePolicy("P105", "David Lee", 1200)
        );

        // Filter premium > 1200
        System.out.println("Policies > $1200:");
        policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .forEach(System.out::println);

        // Sort by holder name
        System.out.println("\nSorted by Holder Name:");
        policies.stream()
                .sorted(Comparator.comparing(InsurancePolicy::getHolderName))
                .forEach(System.out::println);

        // Compute total premium
        double total = policies.stream()
                .mapToDouble(InsurancePolicy::getPremiumAmount)
                .sum();
        System.out.println("\nTotal Premium: $" + total);

        // Print formatted
        System.out.println("\nFormatted Print:");
        policies.forEach(p ->
                System.out.printf("%-5s | %-15s | $%.2f%n",
                        p.getPolicyNumber(),
                        p.getHolderName(),
                        p.getPremiumAmount()));

        // Filter premium between 1000 and 2000
        System.out.println("\nPremium between 1000 and 2000:");
        policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .forEach(System.out::println);

        // Find highest premium
        policies.stream()
                .max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
                .ifPresent(p -> System.out.println("\nHighest Premium: " + p));

        // Group by holder name initial
        System.out.println("\nGrouped by Initial:");
        Map<Character, List<InsurancePolicy>> grouped =
                policies.stream()
                        .collect(Collectors.groupingBy(
                                p -> p.getHolderName().charAt(0)));

        grouped.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });

        // Average premium
        double avg = policies.stream()
                .mapToDouble(InsurancePolicy::getPremiumAmount)
                .average()
                .orElse(0);
        System.out.println("\nAverage Premium: $" + avg);

        // Sort by premium ascending
        System.out.println("\nSorted by Premium:");
        policies.stream()
                .sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
                .forEach(System.out::println);

        // Check any premium > 2000
        boolean anyHigh = policies.stream()
                .anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("\nAny premium > 2000? " + anyHigh);

        // Count by premium ranges
        long range1 = policies.stream()
                .filter(p -> p.getPremiumAmount() <= 1000).count();

        long range2 = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1000 && p.getPremiumAmount() <= 2000).count();

        long range3 = policies.stream()
                .filter(p -> p.getPremiumAmount() > 2000).count();

        System.out.println("\nPremium Ranges Count:");
        System.out.println("0-1000: " + range1);
        System.out.println("1001-2000: " + range2);
        System.out.println(">2000: " + range3);

        // Unique holder names
        System.out.println("\nUnique Holder Names:");
        policies.stream()
                .map(InsurancePolicy::getHolderName)
                .distinct()
                .forEach(System.out::println);

        // Find by substring "Smith"
        System.out.println("\nHolder contains 'Smith':");
        policies.stream()
                .filter(p -> p.getHolderName().contains("Smith"))
                .forEach(System.out::println);

        // Map policy number to premium
        System.out.println("\nMap of Policy to Premium:");
        Map<String, Double> policyMap =
                policies.stream()
                        .collect(Collectors.toMap(
                                InsurancePolicy::getPolicyNumber,
                                InsurancePolicy::getPremiumAmount));

        policyMap.forEach((k, v) ->
                System.out.println(k + " -> $" + v));
    }
}

