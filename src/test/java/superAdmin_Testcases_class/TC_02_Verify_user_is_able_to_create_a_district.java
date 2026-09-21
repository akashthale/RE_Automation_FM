package superAdmin_Testcases_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_DistrictCreation;
import base.BaseTest;

public class TC_02_Verify_user_is_able_to_create_a_district extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_DistrictCreation superadminactionclass;

	@Test
	public void districtCreation() {
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.createDistrict("ED_Test_District_0E", "testfirst", "testlast", "edtestdis310@yopmail.com","Sunil Game");
		Assert.assertEquals(superadminactionclass.getDistrictCreatedSuccessMessage(),
				"SUCCESS! District added successfully", "District was not created successfully");
	}


	@Test
	public void verifyUserIsAbleToSearchTheCreatedDistrict() {
		String expectedDistrict = "ED_Test_District_0E";
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.searchAndVerifyDistrict("Aress Dist4");
		String actualDistrict = superadminactionclass.searchAndGetDistrictName(expectedDistrict);
		Assert.assertEquals(actualDistrict, expectedDistrict,
				"The searched district is not displayed correctly in the table.");

	}


}
