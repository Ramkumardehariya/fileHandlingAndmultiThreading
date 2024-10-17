package fileHandlingAndmultiThreading.fileHandling.assign;

import java.io.File;

public class file {
    public static void main(String[] args) {
        String path = "F:\\javatest\\fileHandling\\assign\\output.txt";

        File f1 = new File(path);

        try {
            f1.createNewFile();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            
        }
    }
}
