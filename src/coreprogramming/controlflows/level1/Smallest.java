package coreprogramming.controlflows.level1;

import java.util.Scanner;

public class Smallest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number1,number2,number3;

        System.out.println("Enter the first number");
        number1 = sc.nextInt();

        System.out.println("Enter the second number");
        number2 = sc.nextInt();

        System.out.println("Enter the third number");
        number3 = sc.nextInt();

        if(number1 < number2 && number1 < number3){
            System.out.println("Number first is the smallest");
        }
        else{
            System.out.println("Number first is not the smallest");
        }
    }
}
