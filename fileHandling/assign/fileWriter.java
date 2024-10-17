package fileHandlingAndmultiThreading.fileHandling.assign;
import java.io.File;
import java.io.FileWriter;

public class fileWriter {

    public static void main(String[] args) { 

        String str = "Hello this is Ram";
        
        try {  
            FileWriter file = new FileWriter("output.txt");
            for(int i = 0; i<str.length(); i++){
                file.write(str.charAt(i));
            }
            file.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    

        System.out.println("file write successfull");

    }
}
