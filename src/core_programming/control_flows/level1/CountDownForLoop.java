package core_programming.control_flows.level1;

import java.util.Scanner;

public class CountDownForLoop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number");
        int counter = sc.nextInt();

        for(int i = counter;i >= 1;i--){
            System.out.println(i);
        }

        System.out.println("Rocket Launched");
    }
}
