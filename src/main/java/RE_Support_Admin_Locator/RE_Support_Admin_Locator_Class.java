package RE_Support_Admin_Locator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RE_Support_Admin_Locator_Class {

	public WebDriver driver;

	public RE_Support_Admin_Locator_Class(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='District']")
	private WebElement Districtbtn;

	public WebElement DistrictButton() {
		return Districtbtn;
	}

	@FindBy(xpath = "//a[@href='https://staging.rippleeffectsweb.com/superadmin/District/add']//span[@class='sidemenu-item'][normalize-space()='Add']")
	private WebElement Addbutton;

	public WebElement addlListtButton() {
		return Addbutton;
	}

	@FindBy(xpath = "//input[@id='district_name']")
	private WebElement enterDistrctName;

	public WebElement enterDistrictName() {
		return enterDistrctName;
	}

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement enterFirstName;

	public WebElement enterFirstName() {
		return enterFirstName;
	}

	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement enterLadtName;

	public WebElement enterlastName() {
		return enterLadtName;
	}

	@FindBy(xpath = "//input[@id='emailid1']")
	private WebElement enterEmailID;

	public WebElement EnterEmailID() {
		return enterEmailID;
	}

	@FindBy(xpath = "//div[@id='uniform-make_primary_admin']//span")
	private WebElement designatedCheckBox;

	public WebElement DesignatedCheckBox() {
		return designatedCheckBox;
	}

	@FindBy(xpath = "//select[@id='support_admin_name_1']")
	private WebElement supportAdminDropdown;

	public WebElement getSupportAdminDropdown() {
		return supportAdminDropdown;
	}

	@FindBy(xpath = "//input[@name='data_viewer_access']")
	private WebElement DDVAccess;

	public WebElement ddvCheckbox() {
		return DDVAccess;
	}

	@FindBy(xpath = "//input[@name='data_viewer_permanent_access']")
	private WebElement legacyAccess;

	public WebElement legacyAccessCheckbox() {
		return legacyAccess;
	}

	@FindBy(css = "div[class='button-wrapper dist-add'] button[type='submit']")
	private WebElement submitBtn;

	public WebElement submitButton() {
		return submitBtn;
	}

	@FindBy(xpath = "//button[@name='no']")
	private WebElement emailPopUp;

	public WebElement getEmailpopUp() {
		return emailPopUp;
	}

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement districtCreatedSuccessMessage;

	public WebElement districtCreatedSuccessMessage() {
		return districtCreatedSuccessMessage;
	}

	// ---------------------------organization
	// locators-------------------------------------//

	@FindBy(xpath = "//span[normalize-space()='Organization']")
	private WebElement organizationButton;

	public WebElement getOrganizationButton() {
		return organizationButton;
	}

	@FindBy(xpath = "(//span[@class='sidemenu-item'][normalize-space()='Add'])[1]")
	private WebElement organizationAddbutton;

	public WebElement getOrganizationAddButton() {
		return organizationAddbutton;
	}

	@FindBy(xpath = "//input[@id='schoolid']")
	private WebElement organizationID;

	public WebElement EnterOrganizationId() {
		return organizationID;
	}

	@FindBy(xpath = "//input[@id='title']")
	private WebElement organizationTitle;

	public WebElement EnterOrganizationTitle() {
		return organizationTitle;
	}

	@FindBy(xpath = "//select[@id='geo_state']")
	private WebElement selectOrgState;

	public WebElement organizationStateDropdown() {
		return selectOrgState;
	}

	@FindBy(xpath = "//input[@id='primary_contact_first_name']")
	private WebElement accountOwnerFirstName;

	public WebElement EnterAccountOwnerFirstName() {
		return accountOwnerFirstName;
	}

	@FindBy(xpath = "//input[@id='primary_contact_last_name']")
	private WebElement accountOwnerLastName;

	public WebElement EnterAccountOwnerLastName() {
		return accountOwnerLastName;
	}

	@FindBy(xpath = "//input[@id='emailid1']")
	private WebElement accountOwnerEmailID;

	public WebElement EnterAccountOwnerEmailId() {
		return accountOwnerEmailID;
	}

	@FindBy(xpath = "//div[@id='uniform-make_primary_admin']//span")
	private WebElement designatedRippleEffetsCheckBox;

	public WebElement checkDesignatedRippleEffectsAdmin() {
		return designatedRippleEffetsCheckBox;
	}

	// NEW: raw <input> for the Designated Ripple Effects Admin checkbox.
	// The existing locator above only ever pointed at the styled <span>
	// (the uniform.js click target), so there was no way to read the actual
	// checked state before clicking. This lets the Action class check
	// isSelected() without needing to click first.
	@FindBy(xpath = "//div[@id='uniform-make_primary_admin']//input")
	private WebElement designatedRippleEffectsInput;

	public WebElement designatedRippleEffectsInput() {
		return designatedRippleEffectsInput;
	}

	// Kept exactly as-is (not the cause of the reported failure). Note it is
	// indexed, which implies more than one element in the DOM matches this
	// xpath - see chat explanation regarding why this needs verification
	// against the actual HTML.
	@FindBy(xpath = "(//input[@name='preview_mode'])[1]")
	private WebElement previewModeCheckBox;

	public WebElement checkpreviewModeCheckBox() {
		return previewModeCheckBox;
	}

	// NEW: click-target locator for Preview Mode.
	// This is a "first match wins" union of the most common ways a
	// custom-styled checkbox exposes a visible/clickable element while the
	// real <input> stays hidden (uniform.js "checker" wrapper, a wrapping
	// <label>, or a sibling <span>/<label>). Only one branch will actually
	// match real markup on the page; the final alternative falls back to the
	// raw input itself so this never throws NoSuchElementException.
	// IMPORTANT: this is a best-effort guess based on the pattern already
	// used for the Designated Ripple Effects checkbox above. If it still
	// times out, the exact wrapper HTML around <input name="preview_mode">
	// is needed - see chat explanation.
	@FindBy(xpath = "(//input[@name='preview_mode'])[1]/ancestor::span[contains(@class,'checker')][1]"
			+ " | (//input[@name='preview_mode'])[1]/ancestor::div[contains(@class,'checker')][1]"
			+ " | (//input[@name='preview_mode'])[1]/ancestor::label[1]"
			+ " | (//input[@name='preview_mode'])[1]/following-sibling::span[1]"
			+ " | (//input[@name='preview_mode'])[1]/following-sibling::label[1]"
			+ " | (//input[@name='preview_mode'])[1]")
	private WebElement previewModeClickTarget;

	public WebElement previewModeClickTarget() {
		return previewModeClickTarget;
	}

	@FindBy(xpath = "//input[@id='turn_on']")
	private WebElement LegacyAccessCheckBox;

	public WebElement checkLegacyAccessCheckBox() {
		return LegacyAccessCheckBox;
	}

	// NEW: click-target locator for Legacy Access (turn_on), same reasoning
	// as previewModeClickTarget above.
	@FindBy(xpath = "//input[@id='turn_on']/ancestor::span[contains(@class,'checker')][1]"
			+ " | //input[@id='turn_on']/ancestor::div[contains(@class,'checker')][1]"
			+ " | //input[@id='turn_on']/ancestor::label[1]" + " | //input[@id='turn_on']/following-sibling::span[1]"
			+ " | //input[@id='turn_on']/following-sibling::label[1]" + " | //input[@id='turn_on']")
	private WebElement legacyAccessClickTarget;

	public WebElement legacyAccessClickTarget() {
		return legacyAccessClickTarget;
	}

	@FindBy(xpath = "//input[@id='kids_mode']")
	private WebElement RippleEffectsForKidsCheckBox;

	public WebElement checkRippleEffectsForKidsCheckBox() {
		return RippleEffectsForKidsCheckBox;
	}

	@FindBy(xpath = "//input[@id='teens_mode']")
	private WebElement RippleEffectsForTeensCheckBox;

	// FIX: this previously returned RippleEffectsForKidsCheckBox (copy-paste
	// bug), so the "Teens" action was actually clicking the "Kids" input a
	// second time and never touching teens_mode at all.
	public WebElement checkRippleEffectsForTeensCheckBox() {
		return RippleEffectsForTeensCheckBox;
	}

	@FindBy(xpath = "//input[@id='sfsk_mode']")
	private WebElement SFSkidsCheckBox;

	public WebElement checkSFSKidsCheckBox() {
		return SFSkidsCheckBox;
	}

	@FindBy(xpath = "//input[@id='sfst_mode']")
	private WebElement SFSTeensCheckBox;

	public WebElement checkSFSteensCheckBox() {
		return SFSTeensCheckBox;
	}

	@FindBy(xpath = "//input[@id='bouncy_resources']")
	private WebElement bouncyProgramCheckBox;

	public WebElement checkBouncyProgramCheckBox() {
		return bouncyProgramCheckBox;
	}

	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Submit'])[1]")
	private WebElement submitbuttonfororganization;

	public WebElement clickOnOrganizationSubmitButton() {
		return submitbuttonfororganization;
	}

	// ========================================organization list locators
	// ===================================================''

	@FindBy(xpath = "(//span[@class='sidemenu-item'][normalize-space()='List'])[1]")
	private WebElement organizationListButton;

	public WebElement clickOrganizationlistButton() {
		return organizationListButton;
	}

	// Organization search box
	@FindBy(css = "#organization_filter input")
	private WebElement OrgSearchBox;

	public WebElement organizationSearchBox() {
		return OrgSearchBox;

	}

	@FindBy(css = "#organization tbody tr td:nth-child(1)")
	private WebElement orgschoolId;

	public WebElement organizationSChoolId() {
		return orgschoolId;

	}
	
	@FindBy(css = "#organization tbody tr td:nth-child(1)")
	private List<WebElement> orgschoolIds;

	public List<WebElement> organizationSchoolIds() {
	    return orgschoolIds;
	}
	

}