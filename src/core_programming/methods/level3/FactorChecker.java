package core_programming.methods.level3;

public class FactorChecker {
    static int[] factors(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) c++;
        int[] f = new int[c];
        int k = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) f[k++] = i;
        return f;
    }

    static boolean isPerfect(int n) {
        int s = 0;
        for (int i = 1; i < n; i++) if (n % i == 0) s += i;
        return s == n;
    }

    static boolean isStrong(int n) {
        int t = n, s = 0;
        while (t > 0) {
            int d = t % 10, f = 1;
            for (int i = 1; i <= d; i++) f *= i;
            s += f;
            t /= 10;
        }
        return s == n;
    }
}

