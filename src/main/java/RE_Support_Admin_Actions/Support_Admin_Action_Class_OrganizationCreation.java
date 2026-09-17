package RE_Support_Admin_Actions;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import RE_Support_Admin_Locator.RE_Support_Admin_Locator_Class;
import Wrappers.TestLogger;
import Wrappers.WebWaits;


public class Support_Admin_Action_Class_OrganizationCreation {

	private WebDriver driver;
	private RE_Support_Admin_Locator_Class supportAdminLocators;

	public Support_Admin_Action_Class_OrganizationCreation(WebDriver driver) {
		this.driver = driver;
		supportAdminLocators = new RE_Support_Admin_Locator_Class(driver);
		TestLogger.info("Support Admin Action Class initialized");
	}

	public void clickonOrganizationnuton() {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.getOrganizationButton(), Duration.ofSeconds(10));
		supportAdminLocators.getOrganizationButton().click();
		TestLogger.pass("District button clicked successfully");
	}

	public void clickOnAddButton() {
		WebWaits.elementToBeClickable(driver, supportAdminLocators.getOrganizationAddButton(), Duration.ofSeconds(10));
		supportAdminLocators.getOrganizationAddButton().click();
		TestLogger.pass("Organization add  button clicked successfully");

	}

	public void enterOrganizationID(String orgname) {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.EnterOrganizationId(), Duration.ofSeconds(10));
		supportAdminLocators.EnterOrganizationId().sendKeys(orgname);
		TestLogger.pass("Organization name entered successfully");
	}

	public void enterOrganizationTitle(String orgTitle) {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.EnterOrganizationTitle(), Duration.ofSeconds(10));
		supportAdminLocators.EnterOrganizationTitle().sendKeys(orgTitle);
		TestLogger.pass("Organization title entered successfully");

	}

	public void selectOrganizationState(String stateName) {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.organizationStateDropdown(), Duration.ofSeconds(10));
		Select select = new Select(supportAdminLocators.organizationStateDropdown());
		select.selectByVisibleText(stateName);
		TestLogger.pass("Organization state selected successfully");

	}

	public void enterAccountOwnerFirstName(String FirstName) {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.EnterAccountOwnerFirstName(), Duration.ofSeconds(10));
		supportAdminLocators.EnterAccountOwnerFirstName().sendKeys(FirstName);
		TestLogger.pass("Organization first name entered successfully");
	}

	public void enterAccountOwnerLastName(String LastName) {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.EnterAccountOwnerLastName(), Duration.ofSeconds(10));
		supportAdminLocators.EnterAccountOwnerLastName().sendKeys(LastName);
		TestLogger.pass("Organization Last name entered successfully");
	}

	public void enterAccountOwnerEmailId(String EmailId) {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.EnterAccountOwnerEmailId(), Duration.ofSeconds(10));
		supportAdminLocators.EnterAccountOwnerEmailId().sendKeys(EmailId);
		TestLogger.pass("Organization Email entered successfully");
	}

	/**
	 * Shared, idempotent checkbox-click routine used by every checkbox action
	 * below.
	 *
	 * stateElement - the raw {@code <input type="checkbox">}. WebDriver's
	 * isSelected() does not require the element to be visible/interactable, so this
	 * is safe to call even when the input itself is hidden by custom styling
	 * (uniform.js, Bootstrap switches, etc.).
	 *
	 * clickTarget - the element that should actually receive the click. For a
	 * plain, unstyled checkbox this can be the same element as stateElement. For a
	 * custom-styled checkbox it should be the visible wrapper (span/div/label) that
	 * the styling library listens for clicks on.
	 *
	 * Behaviour: - Skips the click entirely if the checkbox is already selected, so
	 * re-running this method never accidentally unchecks it. - Prefers a normal
	 * Selenium click(). - Falls back to a JavaScript click ONLY if the normal click
	 * is blocked by an overlay/interception or the element is reported not
	 * interactable - both of which are common with custom-styled checkboxes whose
	 * real click handling is done by a JS library rather than native browser click
	 * semantics.
	 */
	private void clickCheckboxIfNotSelected(WebElement stateElement, WebElement clickTarget, String checkboxName)
			throws ElementClickInterceptedException {
		WebWaits.visibilityOfElement(driver, clickTarget, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickTarget);
		WebWaits.elementToBeClickable(driver, clickTarget, Duration.ofSeconds(10));

		if (stateElement.isSelected()) {
			TestLogger.info(checkboxName + " checkbox is already selected - skipping click to avoid unchecking it");
			return;
		}

		try {
			clickTarget.click();
		} catch (ElementNotInteractableException e) {
			// Normal click genuinely isn't possible here: an overlay/other
			// element is intercepting the click, or the click target isn't
			// natively interactable (typical for spans/divs used purely as
			// styling hooks by JS-driven custom checkboxes). Falling back to
			// a JS click dispatches the click event the styling library is
			// listening for without requiring native pointer interactability.
			TestLogger.info("Standard click on " + checkboxName + " was not possible (" + e.getClass().getSimpleName()
					+ "), falling back to JavaScript click.");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickTarget);
		}

		TestLogger.pass(checkboxName + " checkbox clicked successfully");
	}

	public void clickOnDsignatedRippleEffectsCheckBox() {
		clickCheckboxIfNotSelected(supportAdminLocators.designatedRippleEffectsInput(),
				supportAdminLocators.checkDesignatedRippleEffectsAdmin(), "Designated Ripple Effects");
	}

	public void selectSupportAdmin(String supportAdmin) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				supportAdminLocators.getSupportAdminDropdown());
		WebWaits.visibilityOfElement(driver, supportAdminLocators.getSupportAdminDropdown(), Duration.ofSeconds(10));
		Select select = new Select(supportAdminLocators.getSupportAdminDropdown());
		select.selectByVisibleText(supportAdmin);
		TestLogger.pass("support Admin selected successfully");
	}

	public void clickOnPreviewModeCheckBox() {
		clickCheckboxIfNotSelected(supportAdminLocators.checkpreviewModeCheckBox(),
				supportAdminLocators.previewModeClickTarget(), "Preview Mode");
	}

	// FIX: the original commented-out version of this method scrolled to
	// checkpreviewModeCheckBox() (copy-paste from the method above it)
	// instead of the Legacy Access element, and clicked
	// legacyAccessCheckbox() - which is the DISTRICT flow's
	// data_viewer_permanent_access checkbox, not the Organization flow's
	// turn_on checkbox. This version uses the correct Organization-flow
	// locator (checkLegacyAccessCheckBox / turn_on).
	public void clickOnLegacyAccessCheckBox() {
		clickCheckboxIfNotSelected(supportAdminLocators.checkLegacyAccessCheckBox(),
				supportAdminLocators.legacyAccessClickTarget(), "Legacy Access");
	}

	public void clickOnRippleEffectsForKidsCheckBox() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				supportAdminLocators.checkRippleEffectsForKidsCheckBox());
		supportAdminLocators.checkRippleEffectsForKidsCheckBox().click();
//		clickCheckboxIfNotSelected(supportAdminLocators.checkRippleEffectsForKidsCheckBox(),
//				supportAdminLocators.checkRippleEffectsForKidsCheckBox(), "Ripple Effects for Kids");
	}

	public void clickOnRippleEffectsForTeensCheckBox() {
		supportAdminLocators.checkRippleEffectsForTeensCheckBox().click();
//		clickCheckboxIfNotSelected(supportAdminLocators.checkRippleEffectsForTeensCheckBox(),
//				supportAdminLocators.checkRippleEffectsForTeensCheckBox(), "Ripple Effects for Teens");
	}

	public void clickOnSFSkidsCheckBox() {
		supportAdminLocators.checkSFSKidsCheckBox().click();
//		clickCheckboxIfNotSelected(supportAdminLocators.checkSFSKidsCheckBox(),
//				supportAdminLocators.checkSFSKidsCheckBox(), "SFS Kids");
	}

	public void clickOnSFSTeenCheckBox() {
		supportAdminLocators.checkSFSteensCheckBox().click();
	}

	public void clickOnBouncyCheckBox() {
		supportAdminLocators.checkBouncyProgramCheckBox().click();
//		clickCheckboxIfNotSelected(supportAdminLocators.checkBouncyProgramCheckBox(),
//				supportAdminLocators.checkBouncyProgramCheckBox(), "Bouncy Program");
	}

	public void clickOnSubmitButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				supportAdminLocators.clickOnOrganizationSubmitButton());
		WebWaits.elementToBeClickable(driver, supportAdminLocators.clickOnOrganizationSubmitButton(),
				Duration.ofSeconds(10));
		supportAdminLocators.clickOnOrganizationSubmitButton().click();
		TestLogger.pass("Submit button clicked successfully");

	}

	public void clickonEmailPopUpNo() {
		TestLogger.info("Handling Email popup - clicking No");
		WebWaits.visibilityOfElement(driver, supportAdminLocators.getEmailpopUp(), Duration.ofSeconds(10));

		WebWaits.elementToBeClickable(driver, supportAdminLocators.getEmailpopUp(), Duration.ofSeconds(10));
		supportAdminLocators.getEmailpopUp().click();
		TestLogger.pass("Email popup handled successfully");
	}

	public String getDistrictCreatedSuccessMessage() {
		WebWaits.visibilityOfElement(driver, supportAdminLocators.districtCreatedSuccessMessage(),
				Duration.ofSeconds(10));
		String message = supportAdminLocators.districtCreatedSuccessMessage().getText().trim();
		TestLogger.info("District success message: " + message);
		return message;

	}
	
	public void createOrganization(String orgname, String orgTitle, String stateName, String FirstName, String LastName,
			String EmailId, String supportAdmin) {
		clickonOrganizationnuton();
		clickOnAddButton();
		enterOrganizationID(orgname);
		enterOrganizationTitle(orgTitle);
		selectOrganizationState(stateName);
		enterAccountOwnerFirstName(FirstName);
		enterAccountOwnerLastName(LastName);
		enterAccountOwnerEmailId(EmailId);
		clickOnDsignatedRippleEffectsCheckBox();
		selectSupportAdmin(supportAdmin);
		clickOnPreviewModeCheckBox();
		clickOnLegacyAccessCheckBox();
		clickOnRippleEffectsForKidsCheckBox();
		clickOnRippleEffectsForTeensCheckBox();
		clickOnSFSkidsCheckBox();
		clickOnSFSTeenCheckBox();
		clickOnBouncyCheckBox();
		clickOnSubmitButton();
		clickonEmailPopUpNo();

	}

}