package datahandling;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class SearchEmployee {
    public static void main(String[] args) throws Exception {

        String filepath = "C:\\Users\\akhil\\Downloads\\data.csv";
        String searchName = "AKIL";

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {

            reader.readNext();

            String[] row;

            while((row = reader.readNext()) != null) {
                if(row[1].trim().equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + row[2]);
                    System.out.println("Salary: " + row[3]);
                    break;
                }
            }

        }
    }
}
