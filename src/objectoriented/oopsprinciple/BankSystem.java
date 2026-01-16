package objectoriented.oopsprinciple;

import java.util.ArrayList;

class Customer{
    String name;
    ArrayList<BankAccount> account = new ArrayList<>();

    Customer(String name){
        this.name = name;
    }

    void addAccount(BankAccount b) {
        account.add(b);
    }

    void viewBalance() {
        System.out.println("\nCustomer: " + name);
        for (BankAccount acc : account) {
            System.out.println("Account Number: " + acc.accountNumber +
                    ", Bank: " + acc.bank.bankName +
                    ", Balance: " + acc.balance);
        }
    }
}

class BankAccount{
    String accountNumber;
    double balance;

    Bank bank; // associated with a bank

    BankAccount(String accountNumber, double balance, Bank bank){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }
}

class Bank{
    String bankName;
    ArrayList<Customer> customer = new ArrayList<>();

    Bank(String bankName){
        this.bankName = bankName;
    }

    void addCustomer(Customer c){
        customer.add(c);
    }

    BankAccount openAccount(Customer c, String accountNumber, double initialAmount){
        BankAccount account = new BankAccount(accountNumber, initialAmount, this);
        c.addAccount(account);
        addCustomer(c);

        return account;
    }

    void showAllCustomers(){
        System.out.println("\nCustomers of " + bankName + ":");

        for(Customer c : customer){
            System.out.println("- " + c.name);
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        Bank sbi = new Bank("SBI Bank");

        // creating customer
        Customer akhil = new Customer("Akhil");

        // opening account in two different banks
        hdfc.openAccount(akhil, "4654930", 1000);
        sbi.openAccount(akhil, "3553938", 40000);

        // viewing balance
        akhil.viewBalance();

        // showing customers of each bank
        hdfc.showAllCustomers();
        sbi.showAllCustomers();
    }
}
