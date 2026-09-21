package RE_Support_Admin_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class District_Organization_Link_Locator_Class {
	private WebDriver driver;

	public District_Organization_Link_Locator_Class(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='link organizations']")
	private WebElement linkOrganizationbtn;

	public WebElement clickOnLinkOrganizationButton() {
		return linkOrganizationbtn;
	}

	public WebElement clickonSearchOrganizationInputField(String organizationName) {

		String xpath = "//tr[td[2][normalize-space()='" + organizationName + "']]//input[@type='checkbox']";
		return driver.findElement(By.xpath(xpath));
	}

	@FindBy(xpath = "//button[@type='submit'][normalize-space()='Add']")
	private WebElement addButton;

	public WebElement clickOnAddButton() {
		return addButton;
	}
	
	
	
}
