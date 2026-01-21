package datastructures.runtimeanalysis;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LargeFileReadPerformance {
    static final String FILE_PATH = "C:\\Users\\akhil\\Downloads\\review.txt";

    // file reader
    static long readWithFileReader() throws IOException {
        long start = System.nanoTime();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            while (br.readLine() != null) {
                // just reading, no processing
            }
        }

        return System.nanoTime() - start;
    }

    // inputstream reader
    static long readWithInputStreamReader() throws IOException {
        long start = System.nanoTime();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILE_PATH),
                        StandardCharsets.UTF_8))) {

            while (br.readLine() != null) {
                // just reading, no processing
            }
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args) throws IOException {
        // JVM warm-up
        readWithFileReader();
        readWithInputStreamReader();

        // Actual benchmark
        long fileReaderTime = readWithFileReader();
        long inputStreamReaderTime = readWithInputStreamReader();

        System.out.println("FileReader Time        : " + fileReaderTime / 1_000_000 + " ms");
        System.out.println("InputStreamReader Time : " + inputStreamReaderTime / 1_000_000 + " ms");
    }
}

