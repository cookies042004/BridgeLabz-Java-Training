package core_programming.extraBuiltIn.practiceProblem;

import java.util.Scanner;

public class PrimeChecker {
    static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isPrime(n))
            System.out.println(n + " is a Prime number");
        else
            System.out.println(n + " is NOT a Prime number");
    }
}

