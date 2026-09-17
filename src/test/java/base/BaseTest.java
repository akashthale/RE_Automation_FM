package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	protected ConfigReader config;
	protected ChromeOptions chromeoptions;

//	 WebDriver driver;
//	ConfigReader config;

	@BeforeMethod
	public void setUp() {
		config = new ConfigReader();

		String browser = config.getProperty("browser");
		String url = config.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			

		} else {
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

		}
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
