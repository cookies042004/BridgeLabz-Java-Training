package datastructures.linearbinarysearch;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleToFileWrite {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\akhil\\Downloads\\review.txt";

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter(fileName,true)){

            // taking console input from user
            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            while(true){
                input = bf.readLine();

                if("exit".equalsIgnoreCase(input)) break;

                // writing input to the file
                writer.write(input + System.lineSeparator());
            }

            System.out.println("Input saved to file successfully.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
