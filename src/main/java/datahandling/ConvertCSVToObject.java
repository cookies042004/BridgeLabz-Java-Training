package datahandling;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVToObject {
    static class Student {
        int id;
        String name;
        int marks;

        Student(int id, String name, int marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        public String toString() {
            return id + " " + name + " " + marks;
        }
    }

    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\akhil\\Downloads\\students.csv";
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            reader.readNext();
            String[] row;

            while ((row = reader.readNext()) != null) {

                students.add(new Student(
                        Integer.parseInt(row[0].trim()),
                        row[1],
                        Integer.parseInt(row[2].trim())
                ));
            }
        }

        students.forEach(System.out::println);
    }
}
