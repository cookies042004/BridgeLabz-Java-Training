package coreprogramming.control_flows.level2;

import java.util.Scanner;

public class MultipleUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            int counter = 100;

            while (counter >= 1) {
                if (number % counter == 0) {
                    System.out.println(counter + " perfectly divides the number.");
                }
                counter--;
            }
        }
        else{
            System.out.println("Number should be less than 100 or positive number.");
        }
    }
}

