package RE_Support_Admin_Actions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.util.Assert;

import RE_Support_Admin_Locator.District_Organization_Link_Locator_Class;
import RE_Support_Admin_Locator.RE_Support_Admin_Locator_Class;

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

	public void linkDistrictToOrganization(
            String organizationName,
            String districtName) {

}

/*
 * package RE_Support_Admin_Actions;
 * 
 * import org.openqa.selenium.WebDriver;
 * 
 * import RE_Support_Admin_Locator.District_Organization_Link_Locator_Class;
 * 
 * public class Support_Admin_Action_Class_District_Organization_Link {
 * 
 * private WebDriver driver;
 * 
 * private District_Organization_Link_Locator_Class distOrgLinkLocator;
 * 
 * private Support_Admin_Action_Class_OrganizationCreation organizationAction;
 * 
 * 
 * public Support_Admin_Action_Class_District_Organization_Link(WebDriver
 * driver) {
 * 
 * this.driver = driver;
 * 
 * distOrgLinkLocator = new District_Organization_Link_Locator_Class(driver);
 * 
 * organizationAction = new
 * Support_Admin_Action_Class_OrganizationCreation(driver); }
 * 
 * 
 * public void linkDistrictToOrganization( String organizationName, String
 * districtName) {
 * 
 * // 1. Open Organization List
 * organizationAction.clickOrganizationlistButton();
 * 
 * 
 * // 2. Search Organization
 * organizationAction.searchOrganization(organizationName);
 * 
 * 
 * // 3. Select the required Organization distOrgLinkLocator
 * .organizationSelectCheckbox(organizationName) .click();
 * 
 * 
 * // 4. Click Link District distOrgLinkLocator .clickLinkDistrict();
 * 
 * 
 * // 5. Select the required District distOrgLinkLocator
 * .selectDistrict(districtName);
 * 
 * 
 * // 6. Submit / Save distOrgLinkLocator .clickSubmit(); } }
 */
