package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class TotalIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the salary");
        double salary = sc.nextDouble();

        System.out.println("Enter the bonus amount");
        double bonus = sc.nextDouble();

        double income = salary + bonus;

        System.out.println(
                "The salary is INR " + salary +
                        " and bonus is INR " + bonus +
                        ". Hence Total Income is INR " + income
        );
    }
}
