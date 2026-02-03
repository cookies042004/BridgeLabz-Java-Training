package exceptionhandling;

import java.io.IOException;

public class MixedExceptionExample {
    public static void processData(String data) throws IOException {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (data.equals("error")) {
            throw new IOException("Checked exception occurred");
        }

        System.out.println("Data processed: " + data);
    }

    public static void main(String[] args) {
        try {
            processData("error");

        } catch (IOException e) {
            System.out.println("Handled checked exception: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Handled unchecked exception: " + e.getMessage());
        }
    }
}
