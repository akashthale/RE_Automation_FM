package superAdmin_Testcases_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.District_DataProvider;
import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_DistrictCreation;
import base.BaseTest;
import utilities.ConfigReader;

public class TC_03_Verify_user_is_able_to_create_multiple_district extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_DistrictCreation superadminactionclass;
	public ConfigReader configreader;

	@Test(dataProvider = "districtData", dataProviderClass = District_DataProvider.class)
	public void multipleDistrictCreation(String districtName, String firstName, String lastName, String email,
			String supportAdmin) {

		configreader = new ConfigReader();
		loginAction = new Create_Login_Action_Class(driver);
		loginAction.login(configreader.getProperty("username"), configreader.getProperty("password"));
		superadminactionclass = new Support_Admin_Action_Class_DistrictCreation(driver);
		superadminactionclass.createDistrict(districtName, firstName, lastName, email, supportAdmin);
		Assert.assertEquals(superadminactionclass.getDistrictCreatedSuccessMessage(),
				"SUCCESS! District added successfully", "District was not created successfully");
	}
}