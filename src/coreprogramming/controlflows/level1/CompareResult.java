package coreprogramming.controlflows.level1;

import java.util.Scanner;

public class CompareResult {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

//      taking the number from the user
        System.out.println("Enter the number");
        int n = sc.nextInt();

        int i = 1,total = 0;

        while(i <= n){
            total += i;
            i++;
        }

//      preventing it from the overflow
        long directFormula = (long) n * (n + 1) / 2;

        System.out.println("Result using while loop is " + total);
        System.out.println("Result using formula is " + directFormula);

        if(total == directFormula){
            System.out.println("Result matched");
        }
        else{
            System.out.println("Result not matched");
        }
    }
}
