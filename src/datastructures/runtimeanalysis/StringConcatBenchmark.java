package datastructures.runtimeanalysis;

public class StringConcatBenchmark {
    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) {

        // string
        long startString = System.nanoTime();

        String s = "";
        for (int i = 0; i < ITERATIONS; i++) {
            s = s + "a";
        }

        long endString = System.nanoTime();

        // stringbuilder
        long startBuilder = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append("a");
        }

        long endBuilder = System.nanoTime();

        // stringbuffer
        long startBuffer = System.nanoTime();

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            buffer.append("a");
        }

        long endBuffer = System.nanoTime();

        System.out.println("Iterations: " + ITERATIONS);
        System.out.println("-----------------------------------");
        System.out.println("String Time        : " + (endString - startString) + " ns");
        System.out.println("StringBuilder Time : " + (endBuilder - startBuilder) + " ns");
        System.out.println("StringBuffer Time  : " + (endBuffer - startBuffer) + " ns");
    }
}

