package datahandling;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {

        String file1 = "C:\\Users\\akhil\\Downloads\\students1.csv";
        String file2 = "C:\\Users\\akhil\\Downloads\\students2.csv";
        String output = "C:\\Users\\akhil\\Downloads\\merged.csv";

        Map<String, String[]> map = new HashMap<>();

        try (CSVReader r1 = new CSVReader(new FileReader(file1))) {

            r1.readNext();
            String[] row;

            while ((row = r1.readNext()) != null) {
                map.put(row[0], row);
            }
        }

        try (CSVReader r2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(output))) {

            writer.writeNext(new String[]{"ID","Name","Age","Marks","Grade"});
            r2.readNext();

            String[] row;

            while ((row = r2.readNext()) != null) {
                if (map.containsKey(row[0])) {
                    String[] s1 = map.get(row[0]);
                    writer.writeNext(new String[]{
                            row[0], s1[1], s1[2], row[1], row[2]
                    });
                }
            }
        }

        System.out.println("Merged file created.");
    }
}
