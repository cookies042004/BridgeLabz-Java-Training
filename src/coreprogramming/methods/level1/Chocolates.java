package coreprogramming.methods.level1;

import java.util.Scanner;

public class Chocolates {
    public static int[] calculateChocolates(int dividend, int divisor){
        int eachGet = dividend / divisor;
        int remainder = dividend % divisor;

        return new int[]{eachGet, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of chocolates");
        int dividend = sc.nextInt();

        System.out.println("Enter the number of children");
        int divisor = sc.nextInt();

        int[] result = calculateChocolates(dividend,divisor);

        System.out.println("Each get " + result[0] + " remaining is " + result[1]);
    }
}

