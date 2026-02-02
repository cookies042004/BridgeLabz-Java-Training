package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("C:\\Users\\akhil\\Downloads\\review.txt");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\akhil\\Downloads\\output.txt")){
            int data;

            // reading and writing file data.
            while((data = fis.read()) != -1){
                fos.write(data);
            }
            System.out.println("File copied successfully");
        }catch(FileNotFoundException e){
            System.out.println("File Not exist");
        }catch(IOException e){
            System.out.println("Error occurred while reading/writing file");
        }
    }
}
