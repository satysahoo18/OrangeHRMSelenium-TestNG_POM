package Utility;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class EnvReader {
	Properties prop;
	public String getProperty(String key) throws FileNotFoundException, IOException {
		prop =new Properties();
		prop.load(new FileInputStream("./src/test/resources/GlobalProperties/env.properties"));
		return (String) prop.get(key);
		
	}
}
