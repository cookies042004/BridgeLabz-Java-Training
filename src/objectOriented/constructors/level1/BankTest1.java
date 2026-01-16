package objectOriented.constructors.level1;

class BankAccount1 {
    public int accountNumber;         // public
    protected String accountHolder;   // protected
    private double balance;            // private

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount1 extends BankAccount1 {
    void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
    }
}

public class BankTest1 {
    public static void main(String[] args) {
        SavingsAccount1 acc = new SavingsAccount1();
        acc.accountNumber = 123456;
        acc.accountHolder = "Akhil";
        acc.deposit(5000);

        acc.displayAccount();
    }
}

