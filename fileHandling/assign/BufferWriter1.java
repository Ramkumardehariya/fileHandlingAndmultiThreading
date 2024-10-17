package fileHandlingAndmultiThreading.fileHandling.assign;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferWriter1 {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("output.txt");
            String input = "Mahismati samrajya";
            BufferedWriter bf = new BufferedWriter(writer);
            bf.write(input);
            bf.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }


    }
}
