package objectoriented.specialkeywords;

class BankAccount {
    static String bankName = "HDFC Bank";
    static int totalAccounts = 0;

    final String accountNumber;
    String accountHolderName;

    BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
        }
    }
}

public class AccountSystem {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Akhil", "ACC1001");
        a1.displayDetails();

        BankAccount.getTotalAccounts();
    }
}
