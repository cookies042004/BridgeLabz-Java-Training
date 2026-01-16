package coreprogramming.programming_elements.practice_problem;

import java.util.Scanner;

public class Celsius {
    public static void main(String[] args){
//        celsius to fahrenheit conversion. formula is: Fahrenheit = (week1.day1.practice_problem.Celsius * 9/5) + 32.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the week1.day1.practice_problem.Celsius temperature");
        double celsius = sc.nextDouble();

//        conversion to fahrenheit.
        double fahrenheit = (celsius * 9/5) + 32f;
        System.out.println("Temperature in Fahrenheit is: " + fahrenheit);
    }
}
