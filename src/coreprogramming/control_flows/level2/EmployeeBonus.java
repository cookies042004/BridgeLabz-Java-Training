package coreprogramming.control_flows.level2;

import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter salary");
        double salary = sc.nextDouble();

        System.out.println("Enter year");
        int years = sc.nextInt();

        double bonus = 0;
        if (years > 5) {
            bonus = salary * 0.05;
        }

        System.out.println("bonus is " + bonus);
    }
}
