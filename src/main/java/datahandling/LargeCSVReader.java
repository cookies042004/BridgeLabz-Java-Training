package datahandling;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class LargeCSVReader {
    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\akhil\\Downloads\\large.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            reader.readNext();
            String[] row;

            int batchSize = 100;
            int totalCount = 0;
            List<String[]> batch = new ArrayList<>();

            while ((row = reader.readNext()) != null) {

                batch.add(row);
                totalCount++;

                if (batch.size() == batchSize) {
                    System.out.println("Processed: " + totalCount);
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                System.out.println("Processed: " + totalCount);
            }
        }
    }
}
