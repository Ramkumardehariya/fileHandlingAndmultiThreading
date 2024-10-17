package fileHandlingAndmultiThreading.fileHandling.assign;
import java.io.FileInputStream;

public class fileInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream f1 = new FileInputStream("output.txt");
            int data;

            while((data = f1.read()) != -1){
                System.out.print((char)data);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
