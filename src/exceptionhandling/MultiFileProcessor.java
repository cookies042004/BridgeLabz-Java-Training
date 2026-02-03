package exceptionhandling;

import java.io.*;

public class MultiFileProcessor {
    public static void main(String[] args) {
        try (
                BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
                BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
        ) {

            String line;

            // Read first file
            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            // Read second file
            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Files combined successfully.");

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}

