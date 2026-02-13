package datahandling;

import java.util.Base64;

public class EncryptDecryptCSV {
    public static void main(String[] args) {

        String salary = "50000";

        // Encrypt
        String encrypted = Base64.getEncoder()
                .encodeToString(salary.getBytes());

        System.out.println("Encrypted: " + encrypted);

        // Decrypt
        String decrypted = new String(
                Base64.getDecoder().decode(encrypted));

        System.out.println("Decrypted: " + decrypted);
    }
}
