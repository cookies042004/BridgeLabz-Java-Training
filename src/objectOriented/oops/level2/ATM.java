package objectOriented.oops.level2;

import java.util.Scanner;

class BankAccount{
    String accountHolder;
    int accountNumber;
    double balance;

    // method for depositMoney
    void depositMoney(double amount){
        balance += amount;
    }

    // method for withdrawing money
    void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdraw Amount : " + amount);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    // method for displaying details
    void displayDetails(){
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance : " + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // creating object from class BankAccount
        BankAccount b = new BankAccount();

        // assigning values
        b.accountHolder = "Akhil Puri";
        b.accountNumber = 23423536;
        b.balance = 7000;

        // calling method for adding money
        b.depositMoney(7000);

        // calling method for display details
        b.displayDetails();

        // taking user for amount to withdraw
        System.out.print("Enter amount to withdraw : ");
        int number = sc.nextInt();

        // calling method withdraw with argument number
        b.withdraw(number);

        // again calling method for display details after withdrawing amount to check updated balance
        b.displayDetails();
    }
}
