package RE_Admin_Portal_Locator_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Portal_locators {

	WebDriver driver;

	public Admin_Portal_locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='go-to-new-login']")
	private WebElement LoginBtn;

	public WebElement adminPortalLoginButton() {
		return LoginBtn;
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement emailAddress;

	public WebElement adminPortalEmailAddress() {
		return emailAddress;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	public WebElement adminPortalPassword() {
		return password;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signIn;

	public WebElement signInButton() {
		return signIn;
	}
	

	@FindBy(xpath = "//input[@placeholder='Enter new password']")
	private WebElement newPassword;

	public WebElement newPasswordInputField() {
		return newPassword;
	}

	@FindBy(xpath = "//input[@placeholder='Re-enter new password']")
	private WebElement confirmPassword;

	public WebElement confirmPasswordInputField() {
		return confirmPassword;
	}

	@FindBy(xpath = "//span[normalize-space()='Change password']")
	private WebElement changepassword;

	public WebElement changePasswordButton() {
		return changepassword;
	}
	
	@FindBy(xpath = "//div[@class='sticky-custom']//img[@id='desktop-logo']")
	private WebElement adminPortalLogo;

	public WebElement adminPortalLogo() {
	    return adminPortalLogo;
	}

}
