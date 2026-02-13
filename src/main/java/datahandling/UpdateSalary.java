package datahandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateSalary {
    public static void main(String[] args) throws Exception {

        String filepath = "C:\\Users\\akhil\\Downloads\\data.csv";
        List<String> updatedData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(filepath))) {

            String line = br.readLine();
            updatedData.add(line);

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary = salary * 1.10;
                    data[3] = String.valueOf((int) salary);
                }

                updatedData.add(String.join(",", data));
            }
        }

        // Write to new file
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(filepath))) {

            for (String record : updatedData) {
                bw.write(record);
                bw.newLine();
            }
        }

        System.out.println("Updated file created successfully.");
    }
}
