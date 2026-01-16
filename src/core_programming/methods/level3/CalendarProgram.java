package core_programming.methods.level3;

import java.util.Scanner;

public class CalendarProgram {
    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }

    static int firstDay(int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (1 + x + (31 * m0) / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), y = sc.nextInt();

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (m == 2 && isLeap(y)) days[1] = 29;

        int fd = firstDay(m, y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < fd; i++) System.out.print("    ");
        for (int d = 1; d <= days[m-1]; d++) {
            System.out.printf("%3d ", d);
            if ((d + fd) % 7 == 0) System.out.println();
        }
    }
}

