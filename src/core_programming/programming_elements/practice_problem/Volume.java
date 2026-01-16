package core_programming.programming_elements.practice_problem;

import java.util.Scanner;

public class Volume {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double radius,height;

        System.out.println("Enter the height");
        height = sc.nextDouble();

        System.out.println("Enter the radius");
        radius = sc.nextDouble();

        double volume = Math.PI * Math.pow(radius,2) * height;

        System.out.println("Volume is : " + volume);
    }
}
