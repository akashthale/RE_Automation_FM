package superAdmin_Testcases_class;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.Organization_DataProvider;
import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_OrganizationCreation;
import base.BaseTest;
import utilities.ConfigReader;

public class TC_05_Verify_user_is_able_to_create_multiple_organization extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_OrganizationCreation superadmin_org_action_class;
	public ConfigReader configreader;;

	@Test(dataProvider = "organizationData", dataProviderClass = Organization_DataProvider.class)
	public void createOrganization(String OrgID, String orgTitle, String state, String FName, String LName,
			String email, String SuperAdmin) throws IOException {
		configreader = new ConfigReader();
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(configreader.getProperty("username"), configreader.getProperty("password"));
		superadmin_org_action_class = new Support_Admin_Action_Class_OrganizationCreation(driver);
		superadmin_org_action_class.createOrganization(OrgID, orgTitle, state, FName, LName, email, SuperAdmin);
		Assert.assertEquals(superadmin_org_action_class.getDistrictCreatedSuccessMessage(),
				"SUCCESS! Organization added successfully", "Organization was not created successfully");

	}

}
