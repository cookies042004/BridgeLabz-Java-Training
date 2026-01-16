package coreprogramming.programming_elements.practice_problem;

import java.util.Scanner;

public class Average {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double first,second,third;

        System.out.println("Enter the first number");
        first = sc.nextDouble();

        System.out.println("Enter the second number");
        second = sc.nextDouble();

        System.out.println("Enter the third number");
        third = sc.nextDouble();

        double average = (first + second + third) / 3;

        System.out.println("Average is : "  + average);
    }
}
