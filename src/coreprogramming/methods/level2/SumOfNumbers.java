package coreprogramming.methods.level2;

import java.util.Scanner;

public class SumOfNumbers {
    public static int recursiveSum(int n) {
        if (n == 0)
            return 0;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a Natural Number");
            return;
        }

        int sumRecursion = recursiveSum(n);
        int sumFormula = formulaSum(n);

        System.out.println("Sum using Recursion: " + sumRecursion);
        System.out.println("Sum using Formula: " + sumFormula);

        if (sumRecursion == sumFormula) {
            System.out.println("Both results are correct and equal");
        } else {
            System.out.println("Results are not equal");
        }
    }
}

