package fileHandlingAndmultiThreading.fileHandling.assign;
// package fileHandling.assign;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class fileReader {
    public static void main(String[] args) {
        int ch;

        FileReader f1 = null;

        try{
            f1 = new FileReader("output.txt");

            while ((ch=f1.read())!=-1) {
                System.out.print((char) ch);
            }
            f1.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
