package datahandling;

import java.io.*;

public class ReadAndCnt {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\akhil\\Downloads\\data.csv";

        try(BufferedReader bf = new BufferedReader(new FileReader(filePath))){
            bf.readLine();

            String line;

            int cnt = 0;
            while((line = bf.readLine()) != null){
                if(!line.trim().isEmpty()){
                    cnt++;
                }
            }

            System.out.println(cnt);
            System.out.println(ReadAndCnt.class);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
