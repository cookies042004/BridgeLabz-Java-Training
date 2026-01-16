package coreprogramming.methods.level3;

import java.util.Arrays;

public class Palindrome {
    static int[] reverse(int[] d) {
        int[] r = new int[d.length];
        for (int i = 0; i < d.length; i++)
            r[i] = d[d.length - 1 - i];
        return r;
    }

    static boolean isPalindrome(int n) {
        int[] d = String.valueOf(n).chars().map(c -> c - '0').toArray();
        return Arrays.equals(d, reverse(d));
    }
}

