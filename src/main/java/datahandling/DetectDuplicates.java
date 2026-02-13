package datahandling;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\akhil\\Downloads\\students.csv";
        Set<String> ids = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            reader.readNext();
            String[] row;

            while ((row = reader.readNext()) != null) {

                if (!ids.add(row[0])) {
                    System.out.println("Duplicate: " + String.join(",", row));
                }
            }
        }
    }
}
