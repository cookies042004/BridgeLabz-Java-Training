package regex;

import java.util.Scanner;
import java.util.regex.*;

public class ValidateUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        if(username.matches(regex)){
            System.out.println("Valid username: " + username);
        }
        else{
            System.out.println("Invalid username: " + username);
        }
    }
}
