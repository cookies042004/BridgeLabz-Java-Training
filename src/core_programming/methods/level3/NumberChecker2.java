package core_programming.methods.level3;

public class NumberChecker2 {
    static int[] digits(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').toArray();
    }

    static int sumDigits(int[] d) {
        int s = 0;
        for (int x : d) s += x;
        return s;
    }

    static boolean isHarshad(int n) {
        return n % sumDigits(digits(n)) == 0;
    }

    static int[][] digitFrequency(int[] d) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int x : d) freq[x][1]++;
        return freq;
    }
}

