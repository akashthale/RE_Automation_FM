package Login_Testcase_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import RE_Login_Action_Class.Create_Login_Action_Class;
import base.BaseTest;

public class TC_01_Verify_user_is_able_to_login_sucessfully extends BaseTest {

	public Create_Login_Action_Class create_Login_Action_Class;

	@Test
	public void LoginToRippleEffectsSuperAdmin() {
		create_Login_Action_Class = new Create_Login_Action_Class(driver);

		// login to ripple effects
		create_Login_Action_Class.login(config.getProperty("username"), config.getProperty("password"));

		// Verify Successfull login

		String expetedURL = "https://staging.rippleeffectsweb.com/superadmin/Home";
		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(expetedURL, actualURL, "Login failed: User was not redirected to home page");
	}

}
