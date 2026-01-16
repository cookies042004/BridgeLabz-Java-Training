package core_programming.control_flows.level1;

import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number");
        long number = sc.nextLong();

        if(number == 0){
            System.out.println("zero");
        }
        else if(number > 0){
            System.out.println("positive");
        }
        else{
            System.out.println("negative");
        }
    }
}
