package coreprogramming.methods.level3;

public class NumberChecker {

    static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            d[i] = s.charAt(i) - '0';
        return d;
    }

    static boolean isDuck(int[] d) {
        for (int x : d) if (x == 0) return true;
        return false;
    }

    static boolean isArmstrong(int n, int[] d) {
        int sum = 0, p = d.length;
        for (int x : d) sum += Math.pow(x, p);
        return sum == n;
    }

    static void largestSecondLargest(int[] d) {
        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;
        for (int x : d) {
            if (x > max) { smax = max; max = x; }
            else if (x > smax && x != max) smax = x;
        }
        System.out.println(max + " " + smax);
    }

    static void smallestSecondSmallest(int[] d) {
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for (int x : d) {
            if (x < min) { smin = min; min = x; }
            else if (x < smin && x != min) smin = x;
        }
        System.out.println(min + " " + smin);
    }
}

