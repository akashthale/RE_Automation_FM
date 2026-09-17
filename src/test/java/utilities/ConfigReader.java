package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	private Properties prop;

	public ConfigReader() {

		try {
			FileInputStream file = new FileInputStream("./PropertiesFile/config.properties");
			prop = new Properties();
			prop.load(file);
			file.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
