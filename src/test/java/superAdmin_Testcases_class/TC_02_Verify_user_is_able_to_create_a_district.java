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
<<<<<<< HEAD
		superadminactionclass.createDistrict("Test_dist_dv_A1", "testfirst", "testlast", "akash.thale@aressindia.net",
=======
		superadminactionclass.createDistrict("ED_Test_District_0B", "testfirst", "testlast", "edtestdis307@yopmail.com",
>>>>>>> db7944ef94447dbe740b8ccf02c6585d069e2410
				"Sunil Game");
		Assert.assertEquals(superadminactionclass.getDistrictCreatedSuccessMessage(),
				"SUCCESS! District added successfully", "District was not created successfully");
	}
<<<<<<< HEAD
=======

	@Test
	public void verifyUserIsAbleToSearchTheCreatedDistrict() {
		String expectedDistrict = "ED_Test_District_0B";
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.searchAndVerifyDistrict("Aress Dist4");
		String actualDistrict = superadminactionclass.searchAndGetDistrictName(expectedDistrict);
		Assert.assertEquals(actualDistrict, expectedDistrict,
				"The searched district is not displayed correctly in the table.");

	}
>>>>>>> db7944ef94447dbe740b8ccf02c6585d069e2410

}
