package datahandling;

import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\akhil\\Downloads\\data.csv";

        try(BufferedWriter bf = new BufferedWriter(new FileWriter(filePath))){
            bf.write("ID, Name, Age, Marks\n");
            bf.write("1, Akil, 20, 100\n");
            bf.write("2, Puri, 21, 200\n");

            System.out.println("Completed");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
