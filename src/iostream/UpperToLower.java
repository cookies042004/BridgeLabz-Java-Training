package iostream;

import java.io.*;

public class UpperToLower {

    public static void main(String[] args) {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("C:\\Users\\akhil\\Downloads\\review.txt"));
             BufferedWriter bw =
                     new BufferedWriter(new FileWriter("C:\\Users\\akhil\\Downloads\\output.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("Conversion done.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

