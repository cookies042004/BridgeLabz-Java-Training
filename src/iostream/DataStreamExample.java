package iostream;

import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {

        String file = "C:\\Users\\akhil\\Downloads\\review.txt";

        // Write
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(file))) {

            dos.writeInt(101);
            dos.writeUTF("Akhil");
            dos.writeDouble(8.5);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(file))) {

            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println(roll + " " + name + " " + gpa);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

