package core_programming.methods.level3;

public class Prime {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    static boolean isNeon(int n) {
        int sq = n * n, s = 0;
        while (sq > 0) { s += sq % 10; sq /= 10; }
        return s == n;
    }

    static boolean isSpy(int n) {
        int s = 0, p = 1;
        while (n > 0) {
            int d = n % 10;
            s += d; p *= d;
            n /= 10;
        }
        return s == p;
    }

    static boolean isAutomorphic(int n) {
        return String.valueOf(n * n).endsWith(String.valueOf(n));
    }

    static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }
}

