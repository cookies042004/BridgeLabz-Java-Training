package objectoriented.polymorphism;

import java.util.*;

// interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract Class
abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Securely modify balance
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }

    // Abstract
    public abstract double calculateInterest();

    // General details
    public void getAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder    : " + holderName);
        System.out.println("Balance   : ₹" + balance);
    }
}

// Savings Account
class SavingsAccount extends BankAccount {

    public SavingsAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied for: ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

// CurrentAccount
class CurrentAccount extends BankAccount {

    public CurrentAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied for: ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 50000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA101", "Akhil", 20000));
        accounts.add(new CurrentAccount("CA202", "Riya", 60000));

        for (BankAccount b : accounts) {
            b.getAccountDetails();
            System.out.println("Interest: ₹" + b.calculateInterest());
            System.out.println("Loan Eligible: " + b.calculateLoanEligibility());
            System.out.println("----------------------------------");
        }
    }
}

