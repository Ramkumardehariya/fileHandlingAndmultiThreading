import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        String path = "F:\\javatest\\fileHandling\\practice\\data.txt";
        File file = new File(path);
        //canRead
        //canWrite
        //getName
        // getParent
        // getAboluteFile
        // isfile
        // isDirectory
        // createNewFile
        // mkdir
        // list()
        // delete()

        System.out.println(file.exists());
        System.out.println(file.canWrite());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        System.out.println(file.mkdirs());

        String[] myFile = file.list();

        for(String myfile: myFile){
            System.out.println(myfile);
        }

        System.out.println(file.delete());


    }
}
