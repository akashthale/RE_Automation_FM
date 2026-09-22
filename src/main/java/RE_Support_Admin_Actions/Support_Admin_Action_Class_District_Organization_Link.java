package RE_Support_Admin_Actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import RE_Support_Admin_Locator.District_Organization_Link_Locator_Class;
import RE_Support_Admin_Locator.RE_Support_Admin_Locator_Class;
import Wrappers.TestLogger;
import Wrappers.WebWaits;

public class Support_Admin_Action_Class_District_Organization_Link {

	private WebDriver driver;
	private District_Organization_Link_Locator_Class distOrgLinkLocator;
	private Support_Admin_Action_Class_DistrictCreation districtAction;
	private Support_Admin_Action_Class_OrganizationCreation organizationAction;
	private RE_Support_Admin_Locator_Class SuperadminLocator;

	public Support_Admin_Action_Class_District_Organization_Link(WebDriver driver) {
		this.driver = driver;
		distOrgLinkLocator = new District_Organization_Link_Locator_Class(driver);
		districtAction = new Support_Admin_Action_Class_DistrictCreation(driver);
		organizationAction = new Support_Admin_Action_Class_OrganizationCreation(driver);
		SuperadminLocator = new RE_Support_Admin_Locator_Class(driver);
	}

	public void clickOnLinkOrganizationButton() {
		TestLogger.info("clicking on search organization button");
		WebWaits.visibilityOfElement(driver, distOrgLinkLocator.clickOnLinkOrganizationButton(),
				Duration.ofSeconds(10));
		distOrgLinkLocator.clickOnLinkOrganizationButton().click();
		TestLogger.pass("Clicked in Search Organization Button");
	}

	public void searchOrganization(String organizationName) {

		TestLogger.info("Searching for organization: " + organizationName);
		WebElement searchBox = distOrgLinkLocator.searchOrganizationInputField();
		WebWaits.visibilityOfElement(driver, searchBox, Duration.ofSeconds(10));
		searchBox.clear();
		searchBox.sendKeys(organizationName);
		TestLogger.pass("Organization name entered in search box: " + organizationName);
	}

	public void clickonSelectOrganizationCheckBox(String organizationName) {
		TestLogger.info("clicking on select organization checkbox: " + organizationName);
		WebWaits.visibilityOfElement(driver, distOrgLinkLocator.clickonSearchOrganizationInputField(organizationName),
				Duration.ofSeconds(10));
		distOrgLinkLocator.clickonSearchOrganizationInputField(organizationName).click();
	}

	public void clickOnAddButton() {
		TestLogger.info("clicking on add button");
		WebWaits.visibilityOfElement(driver, distOrgLinkLocator.clickOnAddButton(), Duration.ofSeconds(10));
		distOrgLinkLocator.clickOnAddButton().click();
		TestLogger.pass("Add button clicked successfully");
	}

	public String orgLinkToDistrctSuccessMessage() {
		WebWaits.visibilityOfElement(driver, distOrgLinkLocator.orgDistLinkSucessMessage(), Duration.ofSeconds(10));
		String Successmessage = distOrgLinkLocator.orgDistLinkSucessMessage().getText();
		return Successmessage;

	}

	public void sucessPopUpOKButton() {
		TestLogger.info("clicking on Ok button");
		distOrgLinkLocator.sucesspopupOkButton().click();
		TestLogger.pass("clicked on Ok button successfully");

	}

	public void linkDistrictToOrganization(String organizationName, String districtnName) {

		districtAction.clickonDistectbutton();
		districtAction.clickDistrictList();
		districtAction.searchDistrict(districtnName);
		clickOnLinkOrganizationButton();
		searchOrganization(organizationName);
		clickonSelectOrganizationCheckBox(organizationName);
		clickOnAddButton();
		orgLinkToDistrctSuccessMessage();
	}
}
