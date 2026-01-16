package core_programming.control_flows.level1;

import java.util.Scanner;

public class Vote {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age");
        int age = sc.nextInt();

        if(age < 18){
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
        else{
            System.out.println("The person's age is " + age + " and can vote");
        }
    }
}
