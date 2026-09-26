package Login_Testcase_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import RE_Login_Action_Class.Create_Login_Action_Class;
import Wrappers.WebCommonPath;
import base.BaseTest;
import utilities.ConfigReader;

public class TC_01_Verify_user_is_able_to_login_sucessfully extends BaseTest {

	public Create_Login_Action_Class create_Login_Action_Class;
	public ConfigReader configreader;

	@Test
	public void LoginToRippleEffectsSuperAdmin() {
		create_Login_Action_Class = new Create_Login_Action_Class(driver);
		configreader = new ConfigReader();

		create_Login_Action_Class.login(configreader.getProperty("username"), configreader.getProperty("password"));

		// Verify Successfull login

		String expetedURL = "https://staging.rippleeffectsweb.com/superadmin/Home";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expetedURL, actualURL, "Login failed: User was not redirected to "
				+ "home page");
	}

}
