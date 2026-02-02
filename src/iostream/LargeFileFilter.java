package iostream;

import java.io.*;

public class LargeFileFilter {
    public static void main(String[] args) {

        try (BufferedReader br =
                     new BufferedReader(new FileReader("C:\\Users\\akhil\\Downloads\\review.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

