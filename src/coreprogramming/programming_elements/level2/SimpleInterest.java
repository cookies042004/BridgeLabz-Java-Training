package coreprogramming.programming_elements.level2;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double principal,rate,time;

        System.out.println("Enter the principal amount");
        principal = sc.nextDouble();

        System.out.println("Enter the rate");
        rate = sc.nextDouble();

        System.out.println("Enter the time");
        time = sc.nextDouble();

        double SI = (principal * rate * time)/100;

        System.out.println("SI is : " + SI);
    }
}
