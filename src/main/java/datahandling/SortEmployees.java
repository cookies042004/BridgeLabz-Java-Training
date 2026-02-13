package datahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SortEmployees {
    public static void main(String[] args) throws Exception {

        String filepath = "C:\\Users\\akhil\\Downloads\\data.csv";
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(filepath))){

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                employees.add(line.split(","));
            }
        }

        employees.sort((e1, e2) ->
                Integer.parseInt(e2[3]) - Integer.parseInt(e1[3]));

        System.out.println("Top 5 Highest Paid Employees:");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(String.join(",", employees.get(i)));
        }
    }
}
