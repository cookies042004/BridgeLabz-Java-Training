package coreprogramming.programmingelements.level1;

import java.util.Scanner;

public class SamMark     {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double first,second,third;
        first = 94;
        second = 95;
        third = 96;

        double average = (first + second + third) / 3;

        System.out.println("Sam's average mark in PCM is " + average);
    }
}
