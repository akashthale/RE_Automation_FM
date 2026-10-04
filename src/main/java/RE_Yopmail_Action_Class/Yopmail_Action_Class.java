package RE_Yopmail_Action_Class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import RE_Yopmail_Locator_Class.Yopmail_Locator_Class;
import Wrappers.TestLogger;
import Wrappers.WebWaits;

public class Yopmail_Action_Class {

	private WebDriver driver;
	private WebDriverWait wait;
	public Yopmail_Locator_Class yopMailLocatorClass;

	public Yopmail_Action_Class(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		yopMailLocatorClass = new Yopmail_Locator_Class(driver);
	}

	public void openYopmail(String yopmailUrl) {
		driver.get(yopmailUrl);
		WebWaits.visibilityOfElement(driver, yopMailLocatorClass.emailInputsection(), Duration.ofSeconds(10));
		TestLogger.pass("[PASS] YOPmail opened successfully");
	}

	public void enterTheEmailintoInputBox(String email) {

		WebWaits.visibilityOfElement(driver, yopMailLocatorClass.checkInboxButton(), Duration.ofSeconds(10));
		yopMailLocatorClass.emailInputsection().clear();
		yopMailLocatorClass.emailInputsection().sendKeys(email);
		TestLogger.pass("[PASS] YOPmail username entered: " + email);
		WebWaits.elementToBeClickable(driver, yopMailLocatorClass.checkInboxButton(), Duration.ofSeconds(10));
		yopMailLocatorClass.checkInboxButton().click();
	}

	public String getTheOneTimePassword() {

		TestLogger.pass("\"========== GETTING ONE TIME PASSWORD ==========");

		WebWaits.visibilityOfElement(driver, yopMailLocatorClass.inboxFrame(), Duration.ofSeconds(30));
		driver.switchTo().frame(yopMailLocatorClass.inboxFrame());
		TestLogger.pass("[PASS] Switched to YOPmail email iframe");
		WebWaits.visibilityOfElement(driver, yopMailLocatorClass.getTempararayPassword(), Duration.ofSeconds(30));
		String password = yopMailLocatorClass.getTempararayPassword().getText().trim();
		TestLogger.pass("[PASS] One Time Password retrieved successfully");
		TestLogger.pass("[INFO] One Time Password: " + password);
		driver.switchTo().defaultContent();
		TestLogger.pass("[PASS] Switched back to YOPmail main page");
		return password;
	}

	public String getOneTimePasswordFromYopmail(String yopmailUrl, String email) {
		openYopmail(yopmailUrl);
		enterTheEmailintoInputBox(email);
		String temporaryPassword = getTheOneTimePassword();
		return temporaryPassword;
	}
}