package datastructures.runtimeanalysis;

public class FibonacciPerformance {
    // Recursive Fibonacci (O(2^n))
    static long fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Iterative Fibonacci (O(n))
    static long fibIterative(int n) {
        if (n <= 1) return n;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 40; // ⚠ Recursive explodes beyond this

        // Recursive
        long startRec = System.nanoTime();
        long recResult = fibRecursive(n);
        long endRec = System.nanoTime();

        // Iterative
        long startItr = System.nanoTime();
        long itrResult = fibIterative(n);
        long endItr = System.nanoTime();

        System.out.println("Fibonacci n = " + n);
        System.out.println("Recursive Result : " + recResult);
        System.out.println("Recursive Time   : " + (endRec - startRec) / 1_000_000 + " ms");
        System.out.println("--------------------------------");
        System.out.println("Iterative Result : " + itrResult);
        System.out.println("Iterative Time  : " + (endItr - startItr) + " ns");
    }
}


