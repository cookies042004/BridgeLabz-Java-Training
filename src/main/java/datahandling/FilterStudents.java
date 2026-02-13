package datahandling;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class FilterStudents {
    public static void main(String[] args) throws Exception {

        String filepath = "C:\\Users\\akhil\\Downloads\\data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {

            reader.readNext();

            String[] row;

            System.out.println("Students scoring above 80:");

            while ((row = reader.readNext()) != null) {

                int marks = Integer.parseInt(row[3].trim());

                if (marks > 80) {
                    System.out.println(String.join(",", row));
                }
            }
        }
    }
}
