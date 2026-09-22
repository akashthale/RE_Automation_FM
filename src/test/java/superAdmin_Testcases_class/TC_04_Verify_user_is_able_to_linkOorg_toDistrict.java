package superAdmin_Testcases_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_District_Organization_Link;
import base.BaseTest;

public class TC_04_Verify_user_is_able_to_linkOorg_toDistrict extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_District_Organization_Link distOrglink;

	@Test
	public void linkOrganizationToDistrict() {
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		distOrglink = new Support_Admin_Action_Class_District_Organization_Link(driver);
		distOrglink.linkDistrictToOrganization("Testsborg993", "ED_Test_District_0F");
		Assert.assertEquals(distOrglink.orgLinkToDistrctSuccessMessage(),
				"Organizations are successfully linked to district!");

	}

}
