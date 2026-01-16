package coreprogramming.controlflows.level1;

import java.util.Scanner;

public class CountDownDoWhile {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number");
        int counter = sc.nextInt();

        while(counter >= 1){
            System.out.println(counter--);
        }


        System.out.println("Rocket Launched");
    }
}
