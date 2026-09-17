package RE_Login_Locator_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Login_Locators_Class {

	public WebDriver driver;

	public Create_Login_Locators_Class(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//form[@name='cognitoSignInForm']//div//input[@id='signInFormUsername']")
	private WebElement txtEmail;

	public WebElement getEmailAddress() {
		return txtEmail;
	}

	@FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//form[@name='cognitoSignInForm']//div//input[@id='signInFormPassword']")
	private WebElement txtPassword;

	public WebElement getPassword() {
		return txtPassword;
	}

	@FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//input[@name='signInSubmitButton']")
	private WebElement signInBtn;

	public WebElement getLoginButton() {
		return signInBtn;
	}

}
