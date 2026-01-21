package datastructures.linearbinarysearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrence {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\akhil\\Downloads\\review.txt";
        String targetWord = "void";
        int cnt = 0;

        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = bf.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");

                for(String word : words){
                    if(word.equalsIgnoreCase(targetWord)) cnt++;
                }
            }

            System.out.println("Target word occurrence : " + cnt);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
