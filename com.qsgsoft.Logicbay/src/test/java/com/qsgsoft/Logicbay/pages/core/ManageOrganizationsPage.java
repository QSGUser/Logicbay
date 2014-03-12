package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class ManageOrganizationsPage extends WaitForElement {
	private String selectDivision = "selRootOrgId", 
			orgNamefield = "orgName",
			orgCodefield = "orgCode",
			savebutton = "save",
			selectNew = "//div[@id='dNewMenuItem']",
			selectOrg = "//div[@id='dResultTable']/table[1]";
	public WebDriver driver;

	public ManageOrganizationsPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public ManageOrganizationsPage createOrg(String newOrg, String orgName, String orgCode)
			throws Exception {
		selectDivision(newOrg);
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
		return this;
	}

	public ManageOrganizationsPage selectCreatedOrg(String orgName) throws Exception {
		selectDivision(orgName);
		selectOrg();
		selectNew();
		return this;
	}

	public ManageOrganizationsPage createSubOrg(String orgName, String orgCode) throws Exception {
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
		return this;
	}

	public ManageOrganizationsPage switchToFrame(String frameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(frameName)));
		return this;
	}

	// This function is to select organization form drop down
	public ManageOrganizationsPage selectDivision(String Division) throws Exception {
		switchToFrame("main");
		assertTrue(isElementPresent(By.name(selectDivision), driver));
		new Select(driver.findElement(By.name(selectDivision)))
				.selectByVisibleText(Division);
		return this;
	}

	// This function is to enter organization and sub organization name
	public ManageOrganizationsPage enterOrgName(String orgName) throws Exception {
		switchToFrame("details");
		driver.findElement(By.name(orgNamefield)).clear();
		driver.findElement(By.name(orgNamefield)).sendKeys(orgName);
		assertEquals(orgName, driver.findElement(By.name(orgNamefield))
				.getAttribute("value"));
		return this;
	}

	// This function is to enter organization and sub organization code
	public ManageOrganizationsPage enterCode(String orgCode) throws Exception {
		driver.findElement(By.name(orgCodefield)).clear();
		driver.findElement(By.name(orgCodefield)).sendKeys(orgCode);
		assertEquals(orgCode, driver.findElement(By.name(orgCodefield))
				.getAttribute("value"));
		return this;
	}

	// This function is to save the changes
	public ManageOrganizationsPage selectSave() throws Exception {
		driver.findElement(By.name(savebutton)).click();
		return this;
	}

	// This function is to select organization from results table
	public ManageOrganizationsPage selectOrg() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectOrg)).click();
		return this;
	}

	// This function is to click on new option
	public ManageOrganizationsPage selectNew() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectNew)).click();
		return this;
	}
}