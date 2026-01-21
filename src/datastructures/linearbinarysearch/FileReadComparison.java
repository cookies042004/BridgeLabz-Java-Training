package datastructures.linearbinarysearch;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReadComparison {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\akhil\\Downloads\\review.txt";

        // FileReader
        long startFR = System.nanoTime();
        int wordCountFR = countWordsUsingFileReader(fileName);
        long endFR = System.nanoTime();

        // InputStreamReader
        long startISR = System.nanoTime();
        int wordCountISR = countWordsUsingInputStreamReader(fileName);
        long endISR = System.nanoTime();

        System.out.println("FileReader Words: " + wordCountFR +
                " Time: " + (endFR - startFR));

        System.out.println("InputStreamReader Words: " + wordCountISR +
                " Time: " + (endISR - startISR));
    }

    static int countWordsUsingFileReader(String file) throws IOException {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        }
        return count;
    }

    static int countWordsUsingInputStreamReader(String file) throws IOException {
        int count = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file),
                        StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        }
        return count;
    }
}
