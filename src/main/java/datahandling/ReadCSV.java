package datahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\akhil\\Downloads\\data.csv";

        try(BufferedReader bf = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = bf.readLine()) != null){
                String[] col = line.split(",");

                System.out.println("ID: " + col[0] + " Name: " + col[1] + " Age: " + col[2] + " Marks: " + col[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
