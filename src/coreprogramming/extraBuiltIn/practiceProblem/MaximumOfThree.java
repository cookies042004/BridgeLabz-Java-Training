package coreprogramming.extraBuiltIn.practiceProblem;

import java.util.Scanner;

public class MaximumOfThree {
    static void calculateLarge(int input1,int input2,int input3){
        int largest = Math.max(input1,Math.max(input2,input3));

        System.out.println("Largest Number is " + largest);
    }

    static void takeInput(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number : ");
        int input1 = sc.nextInt();

        System.out.print("Enter the second number : ");
        int input2 = sc.nextInt();

        System.out.print("Enter the third number : ");
        int input3 = sc.nextInt();

        calculateLarge(input1,input2,input3);
    }
    public static void main(String[] args) {
        takeInput();
    }
}
