package RE_Support_Admin_Actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import RE_Support_Admin_Locator.RE_Support_Admin_Locator_Class;
import Wrappers.TestLogger;
import Wrappers.WebWaits;

public class Support_Admin_Action_Class_DistrictCreation {

	private WebDriver driver;
	private RE_Support_Admin_Locator_Class supportAdminLocators;

	public Support_Admin_Action_Class_DistrictCreation(WebDriver driver) {
		this.driver = driver;
		supportAdminLocators = new RE_Support_Admin_Locator_Class(driver);
		TestLogger.info("Support Admin Action Class initialized");
	}

	public void clickonDistectbutton() {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.DistrictButton(), Duration.ofSeconds(10));
		supportAdminLocators.DistrictButton().click();
		TestLogger.pass("District button clicked successfully");
	}

	public void clickonAddbutton() {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.addlListtButton(), Duration.ofSeconds(10));
		supportAdminLocators.addlListtButton().click();
		TestLogger.pass("Add button clicked successfully");
	}

	public void enterDistrictName(String distrctName) {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.enterDistrictName(), Duration.ofSeconds(10));
		supportAdminLocators.enterDistrictName().sendKeys(distrctName);
	}

	public void enterFirstName(String firstName) {
		TestLogger.info("Entering First Name: " + firstName);
		WebWaits.visibilityOfElement(driver, supportAdminLocators.enterFirstName(), Duration.ofSeconds(10));
		supportAdminLocators.enterFirstName().sendKeys(firstName);
		TestLogger.pass("First Name entered successfully");
	}

	public void enterlastName(String lastName) {
		TestLogger.info("Entering Last Name: " + lastName);
		WebWaits.visibilityOfElement(driver, supportAdminLocators.enterlastName(), Duration.ofSeconds(10));
		supportAdminLocators.enterlastName().sendKeys(lastName);
		TestLogger.pass("Last Name entered successfully");
	}

	public void enterEmaiolID(String EmailID) {
		TestLogger.info("Entering Email ID");
		WebWaits.visibilityOfElement(driver, supportAdminLocators.EnterEmailID(), Duration.ofSeconds(10));
		supportAdminLocators.EnterEmailID().sendKeys(EmailID);
		TestLogger.pass("Email ID entered successfully");
	}

	public void clickonDesignatedRECheckbox() {
		TestLogger.info("Selecting Designated RE checkbox");
		WebWaits.visibilityOfElement(driver, supportAdminLocators.DesignatedCheckBox(), Duration.ofSeconds(10));
		supportAdminLocators.DesignatedCheckBox().click();
		TestLogger.pass("Designated RE checkbox selected");
	}

	public void selectSupportAdmin(String userName) {
		TestLogger.info("Selecting Support Admin: " + userName);
		Select select = new Select(supportAdminLocators.getSupportAdminDropdown());
		select.selectByVisibleText(userName);
		TestLogger.pass("Support Admin selected successfully");
	}

	public void clickonDDVCheckbox() {
		TestLogger.info("Selecting DDV checkbox");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				supportAdminLocators.ddvCheckbox());
		// WebWaits.elementToBeClickable(driver,supportAdminLocators.ddvCheckbox(),Duration.ofSeconds(10));
		supportAdminLocators.ddvCheckbox().click();
		TestLogger.pass("DDV checkbox selected");
	}

	public void clickonLegacyAccessCheckbox() {
		// WebWaits.elementToBeClickable(driver,
		// supportAdminLocators.legacyAccessCheckbox(), Duration.ofSeconds(10));
		// WebWaits.visibilityOfElement(driver,
		// supportAdminLocators.legacyAccessCheckbox(), Duration.ofSeconds(10));
		TestLogger.info("Selecting Legacy Access checkbox");
		supportAdminLocators.legacyAccessCheckbox().click();
		TestLogger.pass("Legacy Access checkbox selected");
	}

	public void clickOnSubmmitButton() {
		TestLogger.info("Clicking Submit button");
		// WebWaits.elementToBeClickable(driver, supportAdminLocators.submitButton(),
		// Duration.ofSeconds(10));
		WebWaits.visibilityOfElement(driver, supportAdminLocators.submitButton(), Duration.ofSeconds(10));
		supportAdminLocators.submitButton().click();
		TestLogger.pass("Submit button clicked successfully");

	}

	public void clickonEmailPopUpNo() {
		TestLogger.info("Handling Email popup - clicking No");
		WebWaits.visibilityOfElement(driver, supportAdminLocators.getEmailpopUp(), Duration.ofSeconds(10));

		WebWaits.elementToBeClickable(driver, supportAdminLocators.getEmailpopUp(), Duration.ofSeconds(10));
		supportAdminLocators.getEmailpopUp().click();
		TestLogger.pass("Email popup handled successfully");
	}

	public String getDistrictCreatedSuccessMessage() {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.districtCreatedSuccessMessage(),
				Duration.ofSeconds(10));
		String message = supportAdminLocators.districtCreatedSuccessMessage().getText().trim();
		TestLogger.info("District success message: " + message);
		return message;

	}

	public void createDistrict(String distrctName, String firstName, String lastName, String EmailID,
			String supportAdminName) {
		TestLogger.info("========== Starting District Creation ==========");
		clickonDistectbutton();
		clickonAddbutton();
		enterDistrictName(distrctName);
		enterFirstName(firstName);
		enterlastName(lastName);
		enterEmaiolID(EmailID);
		clickonDesignatedRECheckbox();
		selectSupportAdmin(supportAdminName);
		clickonDDVCheckbox();
		clickonLegacyAccessCheckbox();
		clickOnSubmmitButton();
		clickonEmailPopUpNo();

	}

	// ===================================Search
	// Functioanlity===============================================//

	// Click district List
	public void clickDistrictList() {

		TestLogger.info("Clicking on district List");

		WebWaits.visibilityOfElement(driver, supportAdminLocators.districtListButton(), Duration.ofSeconds(10));
		supportAdminLocators.districtListButton().click();
		TestLogger.pass("District List clicked successfully");
	}

	// Search District
	public void searchDistrict(String districtnName) {

		TestLogger.info("Searching for District: " + districtnName);
		WebElement searchBox = supportAdminLocators.districtSearchField();
		WebWaits.visibilityOfElement(driver, searchBox, Duration.ofSeconds(10));
		searchBox.clear();
		searchBox.sendKeys(districtnName);
		TestLogger.pass("district name entered in search box: " + districtnName);
	}

	public boolean verifyDistrictDisplayed(String districtName) {

		TestLogger.info("Waiting for District to display: " + districtName);

		try {
			List<WebElement> districtNames = supportAdminLocators.districtNames();
			WebWaits.visibilityListOfElements(driver, districtNames, Duration.ofSeconds(15));
			for (WebElement district : districtNames) {
				String displayedDistrict = district.getText().trim();
				TestLogger.info("District displayed in table: " + displayedDistrict);
				if (displayedDistrict.equalsIgnoreCase(districtName)) {
					TestLogger.pass("District matched successfully: " + districtName);
					return true;
				}
			}
			TestLogger.fail("District was not displayed in table: " + districtName);
			return false;

		} catch (Exception e) {

			TestLogger.fail("Error while verifying district: " + districtName + " | " + e.getMessage());
			return false;
		}
	}

	public String searchAndGetDistrictName(String districtName) {
		TestLogger.info("Searching for district: " + districtName);
		WebElement distsearchBox = supportAdminLocators.districtSearchField();
		WebWaits.visibilityOfElement(driver, distsearchBox, Duration.ofSeconds(10));
		distsearchBox.clear();
		distsearchBox.sendKeys(districtName);
		TestLogger.pass("distrct name entered successfully: " + districtName);
		List<WebElement> districtNames = supportAdminLocators.districtNames();
		WebWaits.visibilityListOfElements(driver, districtNames, Duration.ofSeconds(15));
		for (WebElement district : districtNames) {
			String displayedName = district.getText().trim();
			TestLogger.info("District displayed in table: " + displayedName);

			if (displayedName.equalsIgnoreCase(districtName)) {

				TestLogger.pass("District matched successfully: " + districtName);
				return displayedName;
			}
		}

		TestLogger.fail("District was not displayed in table: " + districtName);
		return null;
	}

	public boolean searchAndVerifyDistrict(String districtName){
		clickonDistectbutton();
		clickDistrictList();
		searchDistrict(districtName);
		return verifyDistrictDisplayed(districtName);
	}

}
