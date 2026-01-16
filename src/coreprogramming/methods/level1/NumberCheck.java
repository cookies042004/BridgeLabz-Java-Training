package coreprogramming.methods.level1;

import java.util.Scanner;

public class NumberCheck {
    public static int checkNumber(double n){
        if(n < 0) return -1;

        if(n > 0) return 1;


        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        double n = sc.nextInt();

        int check =  checkNumber(n);

        System.out.println("Number is " + check);
    }
}
