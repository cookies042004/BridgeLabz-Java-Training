package datahandling;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ValidateCSV {
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static void main(String[] args) throws Exception {

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

        try (CSVReader reader = new CSVReader(new FileReader("data.csv"))) {

            reader.readNext();
            String[] row;

            while ((row = reader.readNext()) != null) {

                String email = row[2].trim();
                String phone = row[3].trim();

                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phone.matches("\\d{10}");

                if (!validEmail || !validPhone) {
                    System.out.println("Invalid row: " + String.join(",", row));
                }
            }
        }
    }
}
