package coreprogramming.controlflows.level1;

import java.util.Scanner;

public class UserZero {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double total = 0;
        double val;

        while(true){
            System.out.print("Enter the value ");
            val = sc.nextDouble();

            if(val == 0) break;
            else{
                total += val;
            }
        }

        System.out.println("total value is "+ total);
    }
}
