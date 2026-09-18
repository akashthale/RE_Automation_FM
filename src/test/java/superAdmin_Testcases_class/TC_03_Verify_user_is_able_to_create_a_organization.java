package superAdmin_Testcases_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_OrganizationCreation;
import base.BaseTest;

public class TC_03_Verify_user_is_able_to_create_a_organization extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_OrganizationCreation superadmin_org_action_class;

	@Test
	public void createOrganization() {
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadmin_org_action_class = new Support_Admin_Action_Class_OrganizationCreation(driver);
		superadmin_org_action_class.createOrganization("Test_org_dv_A3", "Test_org_dv_A3", "Ohio", "testakash", "testakash",
				"akash.thale@aressindia.net", "Sunil Game");
		Assert.assertEquals(superadmin_org_action_class.getDistrictCreatedSuccessMessage(),
				"SUCCESS! Organization added successfully", "Organization was not created successfully");

	}

	@Test(enabled = false)
	public void verifyUserIsAbleToSearchTheCreatedOrganization() {
		String expectdOrganization = "Testsborg9";
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadmin_org_action_class = new Support_Admin_Action_Class_OrganizationCreation(driver);
		superadmin_org_action_class.searchAndVerifyOrganization(expectdOrganization);
		String actualOrganization = superadmin_org_action_class.searchAndGetOrganizationName(expectdOrganization);
		Assert.assertEquals(actualOrganization, expectdOrganization,
				"The searched organization is not displayed correctly in the table.");

	}

}
