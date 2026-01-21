package datastructures.linearbinarysearch;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteToCharacter {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\akhil\\Downloads\\review.txt";

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),
                StandardCharsets.UTF_8))){
            String line;

            // reading file line by line
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
