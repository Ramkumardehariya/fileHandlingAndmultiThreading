package fileHandlingAndmultiThreading.fileHandling.assign;
import java.io.FileOutputStream;

public class FileOutputStream1 {
    public static void main(String[] args) {
        
        try{
            FileOutputStream f1 = new FileOutputStream("output.txt");
            f1.write(104);
            f1.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }
}
