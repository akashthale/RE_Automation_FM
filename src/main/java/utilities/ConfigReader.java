package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Wrappers.WebCommonPath;

public class ConfigReader 
{
	private Properties prop;

	public ConfigReader() {

		try {
			FileInputStream file = new FileInputStream(WebCommonPath.loginTestData);
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
