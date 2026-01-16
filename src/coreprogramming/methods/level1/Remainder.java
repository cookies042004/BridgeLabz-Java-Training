package coreprogramming.methods.level1;

import java.util.Scanner;

public class Remainder {
    public static int[] calculateRemainder(int dividend, int divisor){
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dividend");
        int dividend = sc.nextInt();

        System.out.println("Enter the divisor");
        int divisor = sc.nextInt();

        int[] result = calculateRemainder(dividend,divisor);

        System.out.println("Quotient is " + result[0] + " remainder is " + result[1]);
    }
}
