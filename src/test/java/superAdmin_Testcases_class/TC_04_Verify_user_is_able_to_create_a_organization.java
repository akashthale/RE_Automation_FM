package superAdmin_Testcases_class;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_OrganizationCreation;
import Wrappers.WebCommonPath;
import base.BaseTest;
import utilities.ExcelUtil;

public class TC_04_Verify_user_is_able_to_create_a_organization extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_OrganizationCreation superadmin_org_action_class;

	@Test()
	public void createOrganization() throws IOException {
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadmin_org_action_class = new Support_Admin_Action_Class_OrganizationCreation(driver);
		superadmin_org_action_class.createOrganization(
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Organization ID", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Organization Title", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "State", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "First Name", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Last Name", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Email", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Support Admin", "Data"));
		Assert.assertEquals(superadmin_org_action_class.getDistrictCreatedSuccessMessage(),
				"SUCCESS! Organization added successfully", "Organization was not created successfully");

	}

	@Test()
	public void verifyUserIsAbleToSearchTheCreatedOrganization() throws IOException {
		String expectdOrganization = ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Organization ID", "Data");
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadmin_org_action_class = new Support_Admin_Action_Class_OrganizationCreation(driver);
		superadmin_org_action_class.searchAndVerifyOrganization(expectdOrganization);
		String actualOrganization = superadmin_org_action_class.searchAndGetOrganizationName(expectdOrganization);
		Assert.assertEquals(actualOrganization, expectdOrganization,
				"The searched organization is not displayed correctly in the table.");

	}

}
