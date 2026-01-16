package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperature in fahrenheit");
        double fahrenheit = sc.nextDouble();
        double celsiusResult = (fahrenheit - 32) * 5 / 9;

        System.out.println(
                "The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius"
        );
    }
}
