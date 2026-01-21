package datastructures.linearbinarysearch;

public class CompareString {
    public static void main(String[] args) {
        // string using string builder
        StringBuilder stringUsingBuilder = new StringBuilder();
        // string using string buffer
        StringBuffer stringUsingBuffer = new StringBuffer();

        int iterations = 1_000_000;

        // first we are computing time for string-builder
        long startBuilderTime = System.nanoTime();

        for(int i = 0;i < iterations;i++){
            stringUsingBuilder.append("hello");
        }
        long endBuilderTime = System.nanoTime();
        long builderTime = endBuilderTime - startBuilderTime;

        // now computing time for string-buffer
        long startBufferTime = System.nanoTime();

        for(int i = 0;i < iterations;i++){
            stringUsingBuffer.append("hello");
        }

        long endBufferTime = System.nanoTime();
        long bufferTime = endBufferTime - startBufferTime;

        System.out.println("Time taken in builder is : " + builderTime + "(ns)");
        System.out.println("Time taken in buffer is : " + bufferTime + "(ns)");

        System.out.println("\nDifference (Buffer - Builder): "
                + (bufferTime - builderTime) + "(ns)");
    }
}
