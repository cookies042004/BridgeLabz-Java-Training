package datastructures.linearbinarysearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderBuffer {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\akhil\\Downloads\\review.txt"));
        ){
            System.out.println("Enter " + System.nanoTime());
            String line;

            // readLine will search for \n in buffer
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            System.out.println("Exit " + System.nanoTime());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
