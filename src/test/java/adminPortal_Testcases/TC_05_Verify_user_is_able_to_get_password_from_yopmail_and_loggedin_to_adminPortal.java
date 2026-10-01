package adminPortal_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions.Support_Admin_Action_Class_OrganizationCreation;
import RE_Yopmail_Action_Class.Yopmail_Action_Class;
import Wrappers.WebCommonPath;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.ExcelUtil;

public class TC_05_Verify_user_is_able_to_get_password_from_yopmail_and_loggedin_to_adminPortal extends BaseTest {

	public Create_Login_Action_Class loginAction;
	public Support_Admin_Action_Class_OrganizationCreation superadminOrgAction;
	public Yopmail_Action_Class yopmailAction;
	public ConfigReader configreader;

	@Test
	public void verifyUserIsAbleToGetPasswordFromYopmail() throws IOException {

		loginAction = new Create_Login_Action_Class(driver);
		configreader = new ConfigReader();
		loginAction.login(configreader.getProperty("username"), configreader.getProperty("password"));

		superadminOrgAction = new Support_Admin_Action_Class_OrganizationCreation(driver);

		superadminOrgAction.createOrganization(
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Organization ID",
						"Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Organization Title",
						"Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "State", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "First Name", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Last Name", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Email", "Data"),
				ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Support Admin",
						"Data"));

		// VERIFY ORGANIZATION CREATED
		Assert.assertEquals(superadminOrgAction.getDistrictCreatedSuccessMessage(),
				"SUCCESS! Organization added successfully", "Organization was not created successfully");

		// STEP 4 - GET EMAIL FROM EXCEL
		String emailUsed = ExcelUtil.readDataFromExcel(WebCommonPath.SingleOrganizationTestData, "SingleOG", "Email",
				"Data");

		// STEP 5 - REMOVE @yopmail.com
		String yopmailUsername = emailUsed.substring(0, emailUsed.indexOf("@"));

		// STEP 6 - OPEN YOPMAIL AND GET PASSWORD
		yopmailAction = new Yopmail_Action_Class(driver);
		String temporaryPassword = yopmailAction.getOneTimePasswordFromYopmail(configreader.getProperty("yopmailUrl"),
				yopmailUsername);

		// STEP 7 - VERIFY PASSWORD
		Assert.assertNotNull(temporaryPassword, "Temporary password was not retrieved from YOPmail");
		Assert.assertFalse(temporaryPassword.trim().isEmpty(), "Temporary password retrieved from YOPmail is empty");
		System.out.println("[PASS] Temporary password retrieved successfully");
		System.out.println("[INFO] Temporary Password: " + temporaryPassword);
	}
}