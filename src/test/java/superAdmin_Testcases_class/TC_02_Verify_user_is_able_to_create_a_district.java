package superAdmin_Testcases_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.District_DataProvider;
import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_DistrictCreation;
import base.BaseTest;

public class TC_02_Verify_user_is_able_to_create_a_district extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_DistrictCreation superadminactionclass;

	@Test(dataProvider = "districtData", dataProviderClass = District_DataProvider.class)
	public void districtCreation(String districtName, String firstName, String lastName, String email,
			String supportAdmin) {
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.createDistrict(districtName, firstName, lastName, email, supportAdmin);
		Assert.assertEquals(superadminactionclass.getDistrictCreatedSuccessMessage(),
				"SUCCESS! District added successfully", "District was not created successfully");
	}

	@Test(dataProvider = "districtSearchData", dataProviderClass = District_DataProvider.class)
	public void verifyUserIsAbleToSearchTheCreatedDistrict(String districtName) {
		String expectedDistrict = districtName;
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.searchAndVerifyDistrict(expectedDistrict);
		String actualDistrict = superadminactionclass.searchAndGetDistrictName(expectedDistrict);
		Assert.assertEquals(actualDistrict, expectedDistrict,
				"The searched district is not displayed correctly in the table.");

	}

	/*
	
	@Test()
	public void districtCreation() {
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.createDistrict("TestdistrictA11", "testfirst1", "testlast1", "testdist2030@yopmail.com", "supportAdmin");
		Assert.assertEquals(superadminactionclass.getDistrictCreatedSuccessMessage(),
				"SUCCESS! District added successfully", "District was not created successfully");
	}

	@Test()
	public void verifyUserIsAbleToSearchTheCreatedDistrict(String districtName) {
		String expectedDistrict = "TestdistrictA11";
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(config.getProperty("username"), config.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.searchAndVerifyDistrict(expectedDistrict);
		String actualDistrict = superadminactionclass.searchAndGetDistrictName(expectedDistrict);
		Assert.assertEquals(actualDistrict, expectedDistrict,
				"The searched district is not displayed correctly in the table.");

	}
	*/
}