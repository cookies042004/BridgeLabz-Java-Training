package core_programming.control_flows.level2;

import java.util.Scanner;

public class Friend {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter age of Amar");
        int ageAmar = sc.nextInt();

        System.out.println("Enter age of Akbar");
        int ageAkbar = sc.nextInt();

        System.out.println("Enter age of Anthony");
        int ageAnthony = sc.nextInt();

        System.out.println("Enter height of Amar");
        int heightAmar = sc.nextInt();

        System.out.println("Enter height of Akbar");
        int heightAkbar = sc.nextInt();

        System.out.println("Enter height of Anthony");
        int heightAnthony = sc.nextInt();

        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));

        if (youngestAge == ageAmar)
            System.out.println("Amar is the youngest " + youngestAge);
        else if (youngestAge == ageAkbar)
            System.out.println("Akbar is the youngest " + youngestAge);
        else
            System.out.println("Anthony is the youngest " + youngestAge);

        if (tallestHeight == heightAmar)
            System.out.println("Amar is the tallest " + tallestHeight);
        else if (tallestHeight == heightAkbar)
            System.out.println("Akbar is the tallest " + tallestHeight);
        else
            System.out.println("Anthony is the tallest " + tallestHeight);
    }
}
