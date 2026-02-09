package java8features;

import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId, policyNumber;
    double amount;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.isFraudulent = isFraudulent;
    }
}

public class FraudDetection {
    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P1", 15000, true),
                new Transaction("T2", "P1", 20000, true),
                new Transaction("T3", "P2", 5000, true)
        );

        Map<String, List<Transaction>> grouped =
                transactions.stream()
                        .filter(t -> t.isFraudulent && t.amount > 10000)
                        .collect(Collectors.groupingBy(t -> t.policyNumber));

        grouped.forEach((policy, list) -> {
            long count = list.size();
            double total = list.stream().mapToDouble(t -> t.amount).sum();


            if (count > 1 || total > 1000) {
                System.out.println("ALERT: " + policy);
            }

        });
    }
}
