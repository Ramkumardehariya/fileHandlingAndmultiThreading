package fileHandlingAndmultiThreading.fileHandling.assign;
// package fileHandling.assign;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader1 {
    public static void main(String[] args) {
        
            try {
                FileReader reader =  new FileReader("output.txt");
                BufferedReader br = new BufferedReader(reader);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
