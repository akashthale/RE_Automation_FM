package adminPortal_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.Organization_DataProvider;
import RE_Admin_Portal_Action_Class.Admin_Portal_Action_Class;
import RE_Login_Action_Class.Create_Login_Action_Class;
import RE_Support_Admin_Actions_Class.Support_Admin_Action_Class_OrganizationCreation;
import RE_Yopmail_Action_Class.Yopmail_Action_Class;
import base.BaseTest;
import utilities.ConfigReader;

public class TC_07_Verify_user_is_able_to_get_password_from_yopmail_and_loggedin_to_adminPortal
        extends BaseTest {

    public Create_Login_Action_Class loginAction;
    public Support_Admin_Action_Class_OrganizationCreation superadminOrgAction;
    public Admin_Portal_Action_Class adminPortalActionClass;
    public Yopmail_Action_Class yopmailAction;
    public ConfigReader configreader;

    @Test(
        dataProvider = "organizationData",
        dataProviderClass = Organization_DataProvider.class
    )
    public void verifyUserIsAbleToGetPasswordFromYopmail(String OrgID,String orgTitle,String state,String FName, String LName, String email,
            String SuperAdmin) throws IOException {

        // =========================================================
        // STEP 1 - LOGIN TO SUPER ADMIN
        // =========================================================

        loginAction = new Create_Login_Action_Class(driver);
        configreader = new ConfigReader();
        loginAction.login(configreader.getProperty("username"),configreader.getProperty("password"));


        // =========================================================
        // STEP 2 - CREATE ORGANIZATION USING EXCEL DATA
        // =========================================================

        superadminOrgAction =new Support_Admin_Action_Class_OrganizationCreation(driver);
        adminPortalActionClass =new Admin_Portal_Action_Class(driver);
        superadminOrgAction.createOrganization(OrgID,orgTitle,state,FName,LName,email,SuperAdmin);


        // STEP 3 - VERIFY ORGANIZATION CREATED

        Assert.assertEquals(superadminOrgAction.getDistrictCreatedSuccessMessage(),"SUCCESS! Organization added successfully","Organization was not created successfully");

        // STEP 4 - KEEP ORIGINAL EMAIL FROM EXCEL

        String emailUsed = email;
        System.out.println("[INFO] Email from Excel: " + emailUsed);

        // STEP 5 - REMOVE @yopmail.com FOR YOPMAIL
        String yopmailUsername = emailUsed.substring(0,emailUsed.indexOf("@"));
        System.out.println("[INFO] YOPmail username: " + yopmailUsername);

        // STEP 6 - OPEN YOPMAIL AND GET TEMPORARY PASSWORD

        yopmailAction = new Yopmail_Action_Class(driver);

        String temporaryPassword =yopmailAction.getOneTimePasswordFromYopmail(configreader.getProperty("yopmailUrl"),yopmailUsername);


        // STEP 7 - VERIFY TEMPORARY PASSWORD

        Assert.assertNotNull(temporaryPassword,"Temporary password was not retrieved from YOPmail");
        Assert.assertFalse(temporaryPassword.trim().isEmpty(),"Temporary password retrieved from YOPmail is empty");

        System.out.println("[PASS] Temporary password retrieved successfully");


        // STEP 8 - LOGIN TO ADMIN PORTAL
        // USING ORIGINAL EMAIL FROM EXCEL


        adminPortalActionClass.loginOnAdminPortalAdhsboard(configreader.getProperty("adminPortalUrl"),emailUsed,temporaryPassword,
                configreader.getProperty("adminportal_newpassword"),
                configreader.getProperty("adminportal_confirmpassword"));


        // STEP 9 - VERIFY ADMIN PORTAL LOGIN
        Assert.assertTrue(adminPortalActionClass.isAdminPortalLogoDisplayed(),"Admin Portal login failed - Admin Portal logo is not displayed");
        System.out.println("[PASS] Admin Portal login successful. Admin Portal logo is displayed.");
    } 
}