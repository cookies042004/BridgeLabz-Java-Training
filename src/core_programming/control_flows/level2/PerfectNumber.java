package core_programming.control_flows.level2;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n = sc.nextInt();

        if(n > 100 || n < 0){
            System.out.println("Number should be less than 100 or positive.");
            return;
        }

        for(int i = 100;i >= 1;i--){
            if(n % i == 0){
                System.out.println(i + " perfectly divides the number");
            }
        }
    }
}
