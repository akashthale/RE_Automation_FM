package RE_Admin_Portal_Action_Class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import RE_Admin_Portal_Locator_Class.Admin_Portal_locators;
import Wrappers.WebWaits;
import Wrappers.TestLogger;
import Wrappers.WebTextBox;

public class Admin_Portal_Action_Class {

	WebDriver driver;
	Admin_Portal_locators adminPortalLocators;
	WebWaits webwait;
	WebTextBox webtextbox;

	public Admin_Portal_Action_Class(WebDriver driver) {
		this.driver = driver;
		adminPortalLocators = new Admin_Portal_locators(driver);
	}

	public void openAdminPortal(String adminPortalURL) {
		driver.get(adminPortalURL);
		WebWaits.visibilityOfElement(driver, adminPortalLocators.adminPortalLoginButton(), Duration.ofSeconds(10));
		TestLogger.pass("[PASS] Admin Portal opened successfully");
	}

	public void clickOnAdminPOrtalLoginButton() {
		WebWaits.visibilityOfElement(driver, adminPortalLocators.adminPortalLoginButton(), Duration.ofSeconds(10));
		adminPortalLocators.adminPortalLoginButton().click();
		WebWaits.sleep(1000);
	}

	public void enterEmailAddress(String Email) {
		WebWaits.visibilityOfElement(driver, adminPortalLocators.adminPortalEmailAddress(), Duration.ofSeconds(10));
		WebTextBox.sendInput(adminPortalLocators.adminPortalEmailAddress(), Email);
		WebWaits.sleep(1000);
	}

	public void enterPassword(String Password) {
		WebWaits.visibilityOfElement(driver, adminPortalLocators.adminPortalPassword(), Duration.ofSeconds(10));
		WebTextBox.sendInput(adminPortalLocators.adminPortalPassword(), Password);
		WebWaits.sleep(1000);
	}

	public void clickOnSignInButton() {
		WebWaits.elementToBeClickable(driver, adminPortalLocators.signInButton(), Duration.ofSeconds(10));
		adminPortalLocators.signInButton().click();
		WebWaits.sleep(1000);
	}

	public void enterNewPassword(String Newpassword) {
		WebWaits.visibilityOfElement(driver, adminPortalLocators.newPasswordInputField(), Duration.ofSeconds(10));
		WebTextBox.sendInput(adminPortalLocators.newPasswordInputField(), Newpassword);
		WebWaits.sleep(1000);
	}

	public void enterConfirmNewPassword(String Newpassword) {
		WebWaits.visibilityOfElement(driver, adminPortalLocators.confirmPasswordInputField(), Duration.ofSeconds(10));
		WebTextBox.sendInput(adminPortalLocators.confirmPasswordInputField(), Newpassword);
		WebWaits.sleep(1000);
	}

	public void clickOnChangepasswordButton() {
		WebWaits.elementToBeClickable(driver, adminPortalLocators.changePasswordButton(), Duration.ofSeconds(10));
		adminPortalLocators.changePasswordButton().click();
		WebWaits.sleep(1000);
	}

	
	public boolean isAdminPortalLogoDisplayed() {

	    WebWaits.visibilityOfElement (driver,adminPortalLocators.adminPortalLogo(),Duration.ofSeconds(10));
	    return adminPortalLocators.adminPortalLogo().isDisplayed();
	}
	    
	    public void loginOnAdminPortalAdhsboard(String adminPortalURL, String email, String password, String newPassword,
			String Confirmpassword) {
		openAdminPortal(adminPortalURL);
		clickOnAdminPOrtalLoginButton();
		enterEmailAddress(email);
		enterPassword(password);
		clickOnSignInButton();
		enterNewPassword(newPassword);
		enterConfirmNewPassword(Confirmpassword);
		clickOnChangepasswordButton();

	}

}
