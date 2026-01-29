package extrapractice;

import java.util.*;

class WithdrawalRequest {
    int accountNumber;
    double amount;

    WithdrawalRequest(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Map<Integer, Double> accounts = new HashMap<>();
        accounts.put(1001, 50000.0);
        accounts.put(1002, 30000.0);
        accounts.put(1003, 70000.0);

        System.out.println("Accounts:");
        accounts.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nAccounts sorted by balance:");
        TreeMap<Double, Integer> sorted = new TreeMap<>();
        accounts.forEach((k, v) -> sorted.put(v, k));

        sorted.forEach((k, v) ->
                System.out.println("Account " + v + " -> " + k)
        );

        Queue<WithdrawalRequest> queue = new LinkedList<>();
        queue.add(new WithdrawalRequest(1001, 10000));
        queue.add(new WithdrawalRequest(1002, 5000));

        System.out.println("\nProcessing Withdrawals:");
        while (!queue.isEmpty()) {
            WithdrawalRequest wr = queue.remove();
            if (accounts.get(wr.accountNumber) >= wr.amount) {
                accounts.put(wr.accountNumber,
                        accounts.get(wr.accountNumber) - wr.amount);
                System.out.println("Withdrawn " + wr.amount +
                        " from " + wr.accountNumber);
            } else {
                System.out.println("Insufficient balance for " +
                        wr.accountNumber);
            }
        }
    }
}

