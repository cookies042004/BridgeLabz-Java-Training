package exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// FileProcessor class which will read multiple file content
class FileProcessor{
    public void processFiles(List<String> filePaths){
        for(String path : filePaths){
            try(BufferedReader br = new BufferedReader(new FileReader(path))){
                String line;

                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }catch(IOException e){
                System.out.println("Error in file : " + path);
                System.out.println("Reason : " + e.getMessage());
            }

            System.out.println("Completed with file : " + path);
        }
    }
}

public class MultipleFileProcessor {
    public static void main(String[] args) {
        FileProcessor file = new FileProcessor();

        file.processFiles(Arrays.asList("C:\\Users\\akhil\\downloads\\review.txt",
                "file.txt"));
    }
}
