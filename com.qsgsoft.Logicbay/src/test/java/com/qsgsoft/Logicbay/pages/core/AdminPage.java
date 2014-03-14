package com.qsgsoft.Logicbay.pages.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.WebElement.WebElements;
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
	public static WebDriver driver;

	public AdminPage(WebDriver _driver) {
		super(_driver);
		AdminPage.driver = _driver;
	}

	public AdminPage SelectUserAdmin() throws Exception {
		selectUser();
		selectAddUser();
		return this;
	}

	public AdminPage selectAssetOption() throws Exception {
		selectAssets();
		selectManageAssets();
		return this;
	}

	public AdminPage selectGroups() throws Exception {
		selectDisplayGroups();
		selectQuicklinks();
		return this;
	}

	public AdminPage selectUserGroupsAdmin() throws Exception {
		selectUserGroups();
		selectManageOrganizations();
		return this;
	}

	// Function to select users option on admin page
	public void selectUser() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(contentFrameName, "id");
		element = element(users, "xpath");
		action.moveToElement(element).click().build().perform();
	}

	// Function to select Add Users option
	public AdminPage selectAddUser() throws Exception {
		assertTrue(isElementPresent(By.xpath(addusers)));
		element = element(addusers, "xpath");
		element.click();
		return this;
	}

	// Function to select Assets on admin page
	public AdminPage selectAssets() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(contentFrameName, "id");
		element = element(assets, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	// Function to select Manage Assets option
	public AdminPage selectManageAssets() throws Exception {
		assertTrue(isElementPresent(By.xpath(manageAssets)));
		element = element(manageAssets, "xpath");
		element.click();
		return this;
	}

	// Function to return to home from admin Page
	public AdminPage returnToHome() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame(contentFrameName, "id");
		element = element(returnTohome, "xpath");
		element.click();
		return this;
	}

	// Function to select Display Groups option
	public AdminPage selectDisplayGroups() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(contentFrameName, "id");
		element = element(displayGroups, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	// Function to select Quick link option
	public AdminPage selectQuicklinks() throws Exception {
		Actions action = new Actions(driver);
		assertTrue(isElementPresent(By.xpath(quickLinks)));
		element = element(quickLinks, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	// Function to select User groups option
	public AdminPage selectUserGroups() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(contentFrameName, "id");
		element = element(userGroups, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	// Function to select Manage organizations
	public AdminPage selectManageOrganizations() throws Exception {
		assertTrue(isElementPresent(By.xpath(manageOrganizations)));
		element = element(manageOrganizations, "xpath");
		element.click();
		return this;
	}
}