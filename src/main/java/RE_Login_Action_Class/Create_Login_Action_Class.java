package RE_Login_Action_Class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import RE_Login_Locator_Class.Create_Login_Locators_Class;
import Wrappers.WebWaits;

public class Create_Login_Action_Class {

	public WebDriver driver;
	Create_Login_Locators_Class loginLocators = null;

	public Create_Login_Action_Class(WebDriver driver) {
		this.driver = driver;
		loginLocators = new Create_Login_Locators_Class(driver);
	}

	public void enterEmailID(String EmailID) {
		WebWaits.visibilityOfElement(driver, loginLocators.getEmailAddress(), Duration.ofSeconds(10));
		loginLocators.getEmailAddress().sendKeys(EmailID);
	}

	public void EnterPassword(String Password) {
		WebWaits.visibilityOfElement(driver, loginLocators.getPassword(), Duration.ofSeconds(10));
		loginLocators.getPassword().sendKeys(Password);
	}

	public void clickOnSigninButton() {
		WebWaits.elementToBeClickable(driver, loginLocators.getLoginButton(), Duration.ofSeconds(10));
		loginLocators.getLoginButton().click();
	}

	public void login(String EmailID, String Password) {
		enterEmailID(EmailID);
		EnterPassword(Password);
		clickOnSigninButton();

	}

}
