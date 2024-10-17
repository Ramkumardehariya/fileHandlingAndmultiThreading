// package fileHandling.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example2 {
    public static void main(String[] args) {

        try{
            FileWriter fileWriter = new FileWriter("data.txt");
            fileWriter.write("this is a basic things of java ");
            fileWriter.close();
            System.out.println("data written successfully ");
        }catch(IOException e){
            System.out.println("An error occured: "+e.getStackTrace());
        }

    }
}
