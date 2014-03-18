package pages.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lib.WebElements;
import static org.junit.Assert.*;

public class AdminPage extends WebElements {
	private String users = "//img[@id='catBullet6']",
			       addusers = "//td[@id='addLTUser']",
			       returnTohome = "//td[@id='adminLink2']",
			       assets = "//img[@id='catBullet2']",
			       manageAssets = "//td[@id='adminLink3']",
			       displayGroups = "//img[@id='catBullet3']",
			       quickLinks = "//td[@id='adminGoupLink2']",
			       userGroups = "//img[@id='catBullet7']",
			       manageOrganizations = "//td[@id='manageOrgs']",
			       contentFrameName = "contents";
	
	WebElement element;
	public WebDriver driver;

	public AdminPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public AdminPage addUser() throws Exception {
		clickUserAdmin();
		clickAddUser();
		return this;
	}

	public AdminPage addAsset() throws Exception {
		clickAssets();
		clickManageAssets();
		return this;
	}

	public AdminPage addQuickLink() throws Exception {
		clickDisplayGroups();
		clickQuicklinks();
		return this;
	}

	public AdminPage userGroupsAdmin() throws Exception {
		clickUserGroups();
		clickManageOrg();
		return this;
	}
	
	public AdminPage verifyAdminPage(String title)throws Exception{
		waitForPageToLoad();
		String adminPagetitle = driver.getTitle();
		assertTrue(adminPagetitle.contains(title));
		return this;
	}

	// Function to select users option on admin page
	public AdminPage clickUserAdmin() throws Exception {
		switchToFrame(contentFrameName, "id");
		element = getElement(users, "xpath");
		element.isDisplayed();
		element.click();
		return this;
	}

	// Function to select Add Users option
	public AdminPage clickAddUser() throws Exception {
		assertTrue(isElementPresent(By.xpath(addusers)));
		element = getElement(addusers, "xpath");
		element.click();
		return this;
	}

	// Function to select Assets on admin page
	public AdminPage clickAssets() throws Exception {
		switchToFrame(contentFrameName, "id");
		element = getElement(assets, "xpath");
		element.click();
		return this;
	}

	// Function to select Manage Assets option
	public AdminPage clickManageAssets() throws Exception {
		assertTrue(isElementPresent(By.xpath(manageAssets)));
		element = getElement(manageAssets, "xpath");
		element.click();
		return this;
	}

	// Function to return to home from admin Page
	public AdminPage returnToHome() throws Exception {
		switchToFrame(contentFrameName, "id");
		element = getElement(returnTohome, "xpath");
		element.click();
		return this;
	}

	// Function to select Display Groups option
	public AdminPage clickDisplayGroups() throws Exception {
		switchToFrame(contentFrameName, "id");
		element = getElement(displayGroups, "xpath");
		element.click();
		return this;
	}

	// Function to select Quick link option
	public AdminPage clickQuicklinks() throws Exception {
		assertTrue(isElementPresent(By.xpath(quickLinks)));
		element = getElement(quickLinks, "xpath");
		element.click();
		return this;
	}

	// Function to select User groups option
	public AdminPage clickUserGroups() throws Exception {
		switchToFrame(contentFrameName, "id");
		element = getElement(userGroups, "xpath");
		element.click();
		return this;
	}

	// Function to select Manage organizations
	public AdminPage clickManageOrg() throws Exception {
		assertTrue(isElementPresent(By.xpath(manageOrganizations)));
		element = getElement(manageOrganizations, "xpath");
		element.click();
		return this;
	}
}