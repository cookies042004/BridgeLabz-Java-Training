package datahandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class JSONToCSV {
    static class Student {
        public int id;
        public String name;
        public int marks;
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<Student> students =
                Arrays.asList(mapper.readValue(
                        new File("students.json"), Student[].class));

        CSVWriter writer = new CSVWriter(
                new FileWriter("students.csv"));

        writer.writeNext(new String[]{"id","name","marks"});

        for (Student s : students) {
            writer.writeNext(new String[]{
                    String.valueOf(s.id),
                    s.name,
                    String.valueOf(s.marks)
            });
        }

        writer.close();

        System.out.println("Converted JSON to CSV.");
    }
}
