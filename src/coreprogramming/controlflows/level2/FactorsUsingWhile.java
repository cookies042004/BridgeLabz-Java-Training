package coreprogramming.controlflows.level2;

import java.util.Scanner;

public class FactorsUsingWhile {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int number = sc.nextInt();

        if (number > 0) {
            int counter = 1;
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        }
    }
}

