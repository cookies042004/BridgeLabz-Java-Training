package coreprogramming.extrabuiltin.practiceproblem;

import java.util.Scanner;
import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter date (yyyy-mm-dd) : ");
        String input = sc.next();

        LocalDate local = LocalDate.parse(input);

        LocalDate result = local.plusDays(7).plusMonths(1).plusYears(2).
                minusWeeks(3);

        System.out.println("Original Date " + local);
        System.out.println("Modified Date " + result);
    }
}
