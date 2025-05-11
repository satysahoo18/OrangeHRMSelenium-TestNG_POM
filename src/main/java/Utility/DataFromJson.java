  package Utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataFromJson {
	public static List<HashMap<String, String>> getData(String path) throws IOException {
		// get the path of the file 
		File JSONPath = new File(System.getProperty("user.dir") + path);
		
		// Convert JSON file to String file 
		String  JSONData = FileUtils.readFileToString(JSONPath, StandardCharsets.UTF_8);
		
		// Converting the above string file to list of hashmap
		ObjectMapper objectMapper = new ObjectMapper();
		
		   //Creating typerefence object to cast string json data to list of hashmaps
		
		   TypeReference<List<HashMap<String, String>>> listType = new TypeReference<List<HashMap<String,String>>>(){};
		   
		   // passing the String json data and typereference object and capturing the data into a list of hashmap
		  List<HashMap<String,String>> validCreds = objectMapper.readValue(JSONData, listType);
		  
		  return validCreds;
		
		
				
	}
}
