package core_programming.control_flows.level1;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number1,number2,number3;

        System.out.print("Enter the first number");
        number1 = sc.nextInt();

        System.out.print("Enter the second number");
        number2 = sc.nextInt();

        System.out.print("Enter the third number");
        number3 = sc.nextInt();

        boolean isFirst = (number1 > number2) && (number1 > number3);
        boolean isSecond = (number2 > number1) && (number2 > number3);
        boolean isThird = (number3 > number2) && (number3 > number1);

        System.out.println("Is the first number the largest? " + isFirst);
        System.out.println("Is the second number the largest? " + isSecond);
        System.out.println("Is the third number the largest? " + isThird);
    }
}
