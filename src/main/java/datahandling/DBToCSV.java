package datahandling;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.sql.*;

public class DBToCSV {
    public static void main(String[] args) throws Exception {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

        CSVWriter writer = new CSVWriter(
                new FileWriter("C:\\Users\\akhil\\Downloads\\report.csv"));

        writer.writeNext(new String[]{"Employee ID","Name","Department","Salary"});

        while (rs.next()) {
            writer.writeNext(new String[]{
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getString("salary")
            });
        }

        writer.close();
        conn.close();

        System.out.println("Report generated.");
    }
}
