package fileHandlingAndmultiThreading.fileHandling.assign;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class JosnFileHandlingExample {

	public static void main(String[] args) {

		JSONObject obj = new JSONObject();
		obj.put("name", "sonoo");
		obj.put("age", 27);
		obj.put("salary", 600000.0);

		writeJsonToFile("D:\\java\\jsondata.json", obj);

		readJsonFromFile("D:\\java\\jsondata.json");
	}

	
	public static void writeJsonToFile(String filePath, JSONObject json) {
		try (FileWriter file = new FileWriter(filePath)) {
			file.write(json.toString(4)); 
			System.out.println("JSON successfully written to " + filePath);
		} catch (IOException e) {
			System.out.println("An error occurred while writing JSON to file: " + e.getMessage());
		}
	}

	
	public static void readJsonFromFile(String filePath) {
		try (FileReader reader = new FileReader(filePath)) {
			StringBuilder jsonContent = new StringBuilder();
			int i;
			while ((i = reader.read()) != -1) {
				jsonContent.append((char) i);
			}
			System.out.println("JSON read from file:");
			System.out.println(jsonContent);
		} catch (IOException e) {
			System.out.println("An error occurred while reading JSON from file: " + e.getMessage());
		}
	}

}