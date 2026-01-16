package coreprogramming.controlflows.level2;

import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int number = sc.nextInt();

        System.out.println("Enter the power");
        int power = sc.nextInt();

        if (number > 0 && power >= 0) {
            int result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println("Power is : " + result);
        }
    }
}

