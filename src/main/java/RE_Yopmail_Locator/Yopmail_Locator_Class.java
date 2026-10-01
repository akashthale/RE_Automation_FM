package RE_Yopmail_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Yopmail_Locator_Class {

	
	public WebDriver driver;

	public Yopmail_Locator_Class(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='login']")
	private WebElement emailinput;

	public WebElement emailInputsection() {
		return emailinput;
	}

	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	private WebElement checkbox;

	public WebElement checkInboxButton() {
		return checkbox;
	}
	
	@FindBy(xpath = "//iframe[@id = 'ifmail']")
	private WebElement iframe;

	public WebElement inboxFrame() {
		return iframe;
	}
	
	@FindBy(xpath = "//ol/li[2]/p[1]")
	private WebElement tempararypassword;

	public WebElement getTempararayPassword() {
		return tempararypassword;
	}
}











