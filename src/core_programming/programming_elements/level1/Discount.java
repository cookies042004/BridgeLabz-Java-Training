package core_programming.programming_elements.level1;

import java.util.Scanner;

public class Discount {
    public static void main(String[] args){
//        int fee = 125000;
//        int discountPercent = 10;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the fee");
        int fee = sc.nextInt();

        System.out.println("Enter the discount");
        int discountPercent = sc.nextInt();

        double discount = (double) fee * discountPercent / 100;
        double discountedFee = fee - discount;

        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + discountedFee);
    }
}
