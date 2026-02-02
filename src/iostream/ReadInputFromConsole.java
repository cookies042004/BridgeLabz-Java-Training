package iostream;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInputFromConsole {
    public static void main(String[] args) {
         String filePath = "C:\\Users\\akhil\\Downloads\\output.txt";

         try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(filePath)){

             System.out.print("Enter your name: ");
             String name = br.readLine();

             System.out.print("Enter your age: ");
             String age = br.readLine();

             System.out.print("Enter your favorite programming language: ");
             String language = br.readLine();

             fw.write("Name: " + name + "\n");
             fw.write("Age: " + age + "\n");
             fw.write("Favorite Language: " + language + "\n");

         }
         catch(IOException e){
             System.out.println("An error occurred");
             e.printStackTrace();
         }
    }
}
