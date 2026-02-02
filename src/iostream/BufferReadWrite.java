package iostream;

import java.io.*;

public class BufferReadWrite {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\akhil\\Downloads\\review.txt";
        String outputFile1 = "C:\\Users\\akhil\\Downloads\\output.txt";
        String outputFile2 = "C:\\Users\\akhil\\Downloads\\output.txt";

        byte[] buffer = new byte[4096];

        // Unbuffered
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile1)) {

            long start = System.nanoTime();

            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();

            System.out.println("Unbuffered Time: " + (end - start) + " ns");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Buffered
        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(outputFile2))) {

            long start = System.nanoTime();

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();

            System.out.println("Buffered Time: " + (end - start) + " ns");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
