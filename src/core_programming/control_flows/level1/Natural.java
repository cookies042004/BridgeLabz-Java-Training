package core_programming.control_flows.level1;

import java.util.Scanner;

public class Natural {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        long number = sc.nextLong();

        if(number < 0){
            System.out.println("The number " + number +  " is not a natural number");
        }
        else{
            long sum = number * (number + 1) / 2;
            System.out.println("The sum of " + number + "natural number is " + sum);
        }
    }
}
