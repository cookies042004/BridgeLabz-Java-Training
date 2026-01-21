package datastructures.linearbinarysearch;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        long startSB = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }

        long endSB = System.nanoTime();

        // StringBuffer
        StringBuffer buffer = new StringBuffer();
        long startBuffer = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            buffer.append("hello");
        }

        long endBuffer = System.nanoTime();

        System.out.println("StringBuilder Time: " + (endSB - startSB));
        System.out.println("StringBuffer Time : " + (endBuffer - startBuffer));
    }
}

