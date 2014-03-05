package com.qsgsoft.Logicbay.pages.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class AdminPage extends WaitForElement {
	private static String selectUsers = "//img[@id='catBullet6']";
	private static String selectAddUsers = "//td[@id='addLTUser']";
	private static String selectReturn = "//td[@id='adminLink2']";
	private static String selectAssets = "//img[@id='catBullet2']";
	private static String selectManageAssets = "//td[@id='adminLink3']";
	private static String selectDisplayGroups = "//img[@id='catBullet3']";
	private static String selectQuickLinks = "//td[@id='adminGoupLink2']";
	private static String selectUserGroups = "//img[@id='catBullet7']";
	private static String selectManageOrganizations = "//td[@id='manageOrgs']";
	public WebDriver driver;
	
	public AdminPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void SelectUserAdmin() throws Exception {
		selectUser();
		selectAddUser();
	}

	public void selectAssetManagement() throws Exception {
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
	//Function to select users option on admin page
	public void selectUser() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("contents")));
		action.moveToElement(driver.findElement(By.xpath(selectUsers))).click()
		.build().perform();
	}
	//Function to select Add Users option
	public void selectAddUser() throws Exception {
		assertTrue(isElementPresent(By.xpath(selectAddUsers), driver));
		driver.findElement(By.xpath(selectAddUsers)).click();
	}
	//Function to select Assets on admin page
	public void selectAssets() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("contents")));
		action.moveToElement(driver.findElement(By.xpath(selectAssets)))
		.click().build().perform();
	}
	//Function to select Manage Assets option
	public void selectManageAssets() throws Exception {
		assertTrue(isElementPresent(By.xpath(selectManageAssets), driver));
		driver.findElement(By.xpath(selectManageAssets)).click();
	}
	//Function to return to home from admin Page
	public void returnToHome() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("contents")));
		driver.findElement(By.xpath(selectReturn)).click();
	}
	//Function to select Display Groups option
	public void selectDisplayGroups() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("contents")));
		action.moveToElement(driver.findElement(By.xpath(selectDisplayGroups)))
		.click().build().perform();
	}
	//Function to select Quick link option
	public void selectQuicklinks() throws Exception {
		Actions action = new Actions(driver);
		assertTrue(isElementPresent(By.xpath(selectQuickLinks), driver));
		// driver.findElement(By.xpath(selectQuickLinks)).click();
		action.moveToElement(driver.findElement(By.xpath(selectQuickLinks)))
		.click().build().perform();
	}
	//Function to select User groups option
	public void selectUserGroups() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("contents")));
		action.moveToElement(driver.findElement(By.xpath(selectUserGroups)))
		.click().build().perform();
	}
	//Function to select Manage organizations
	public void selectManageOrganizations() throws Exception {
		assertTrue(isElementPresent(By.xpath(selectManageOrganizations), driver));
		driver.findElement(By.xpath(selectManageOrganizations)).click();
	}
}