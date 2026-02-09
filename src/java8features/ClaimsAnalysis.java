package java8features;

import java.util.*;
import java.util.stream.*;

class Claim {
    String claimId, policyNumber, status;
    double claimAmount;

    Claim(String claimId, String policyNumber, double claimAmount, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.status = status;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P1", 7000, "Approved"),
                new Claim("C2", "P1", 8000, "Approved"),
                new Claim("C3", "P2", 2000, "Rejected")
        );

        Map<String, List<Claim>> grouped =
                claims.stream()
                        .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                        .collect(Collectors.groupingBy(c -> c.policyNumber));

        Map<String, Double> total =
                grouped.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> e.getValue().stream()
                                        .mapToDouble(c -> c.claimAmount).sum()));

        System.out.println("Grouped: " + grouped);
        System.out.println("Total per Policy: " + total);
    }
}

