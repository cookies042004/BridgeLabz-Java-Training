package regex;

import java.util.Scanner;

public class ValidHex {
    public static boolean isValidHex(String color) {
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter color code: ");
        String licenseNumber = sc.nextLine();

        if(isValidHex(licenseNumber)) {
            System.out.println("valid");
        }else{
            System.out.println("Not valid");
        }
    }
}
