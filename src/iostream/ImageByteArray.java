package iostream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageByteArray {
    public static void main(String[] args) {
        String input = "C:\\Users\\akhil\\Downloads\\bhai straight sign (2).jpg";
        String output = "C:\\Users\\akhil\\Downloads\\bhai straight sign (1).jpg";

        try (FileInputStream fis = new FileInputStream(input);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            try (FileOutputStream fos = new FileOutputStream(output)) {
                fos.write(imageBytes);
            }

            System.out.println("Image copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
