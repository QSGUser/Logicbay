package com.qsgsoft.Logicbay.pages.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class AdminPage extends WaitForElement {
	private String users = "//img[@id='catBullet6']",
			addusers = "//td[@id='addLTUser']",
			returnTohome = "//td[@id='adminLink2']",
			assets = "//img[@id='catBullet2']",
			manageAssets = "//td[@id='adminLink3']",
			displayGroups = "//img[@id='catBullet3']",
			quickLinks = "//td[@id='adminGoupLink2']",
			userGroups = "//img[@id='catBullet7']",
			manageOrganizations = "//td[@id='manageOrgs']";
	public WebDriver driver;

	public AdminPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void switchToFrame(String frameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name(frameName)));
	}

	public void SelectUserAdmin() throws Exception {
		selectUser();
		selectAddUser();
	}

	public void selectAssetOption() throws Exception {
		selectAssets();
		selectManageAssets();
	}

	public void selectGroups() throws Exception {
		selectDisplayGroups();
		selectQuicklinks();
	}

	public void selectUserGroupsAdmin() throws Exception {
		selectUserGroups();
		selectManageOrganizations();
	}

	// Function to select users option on admin page
	public void selectUser() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("contents");
		action.moveToElement(driver.findElement(By.xpath(users))).click()
				.build().perform();
	}

	// Function to select Add Users option
	public void selectAddUser() throws Exception {
		assertTrue(isElementPresent(By.xpath(addusers), driver));
		driver.findElement(By.xpath(addusers)).click();
	}

	// Function to select Assets on admin page
	public void selectAssets() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("contents");
		action.moveToElement(driver.findElement(By.xpath(assets)))
				.click().build().perform();
	}

	// Function to select Manage Assets option
	public void selectManageAssets() throws Exception {
		assertTrue(isElementPresent(By.xpath(manageAssets), driver));
		driver.findElement(By.xpath(manageAssets)).click();
	}

	// Function to return to home from admin Page
	public void returnToHome() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("contents");
		driver.findElement(By.xpath(returnTohome)).click();
	}

	// Function to select Display Groups option
	public void selectDisplayGroups() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("contents");
		action.moveToElement(driver.findElement(By.xpath(displayGroups)))
				.click().build().perform();
	}

	// Function to select Quick link option
	public void selectQuicklinks() throws Exception {
		Actions action = new Actions(driver);
		assertTrue(isElementPresent(By.xpath(quickLinks), driver));
		action.moveToElement(driver.findElement(By.xpath(quickLinks)))
				.click().build().perform();
	}

	// Function to select User groups option
	public void selectUserGroups() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("contents");
		action.moveToElement(driver.findElement(By.xpath(userGroups)))
				.click().build().perform();
	}

	// Function to select Manage organizations
	public void selectManageOrganizations() throws Exception {
		assertTrue(isElementPresent(By.xpath(manageOrganizations), driver));
		driver.findElement(By.xpath(manageOrganizations)).click();
	}
}