package core_programming.methods.level1;

import java.util.Scanner;

public class HandShakes {
    public static int calculateHands(int n){
        int handShakes = (n * (n - 1)) / 2;

        return handShakes;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Students");
        int n = sc.nextInt();

        int handShakes = calculateHands(n);

        System.out.println("Number of possible handshakes is " + handShakes);
    }
}
