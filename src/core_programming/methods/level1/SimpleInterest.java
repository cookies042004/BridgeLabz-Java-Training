package core_programming.methods.level1;

import java.util.Scanner;

public class SimpleInterest {
    public static double calculateSI(double p, double r, double t){
        double si = (p * r * t)/ 100;

        return si;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter principal amount");
        double principal = sc.nextDouble();

        System.out.println("Enter rate");
        double rate = sc.nextDouble();

        System.out.println("Enter time");
        double time = sc.nextDouble();

        double simpleInterest = calculateSI(principal,rate,time);

        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " +
                principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}
