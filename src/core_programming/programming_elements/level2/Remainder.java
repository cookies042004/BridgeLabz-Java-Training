package core_programming.programming_elements.level2;

import java.util.Scanner;

public class Remainder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number1,number2;

        System.out.println("Enter the first number");
        number1 = sc.nextInt();

        System.out.println("Enter the second number");
        number2 = sc.nextInt();

        if(number2 == 0){
            System.out.println("Not divisible by 0");
        }

        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder +
                " of two number " + number1 + " and " + number2);
    }
}
