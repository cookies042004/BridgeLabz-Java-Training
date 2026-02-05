package regex;

import java.util.Scanner;

public class ValidateNumber {
    public static boolean isValidLicense(String plate) {
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plate number: ");
        String licenseNumber = sc.nextLine();

        if(isValidLicense(licenseNumber)) {
            System.out.println("valid");
        }else{
            System.out.println("Not valid");
        }
    }
}
