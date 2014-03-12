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

	public void createOrg(String newOrg, String orgName, String orgCode)
			throws Exception {
		selectDivision(newOrg);
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
	}

	public void selectCreatedOrg(String orgName) throws Exception {
		selectDivision(orgName);
		selectOrg();
		selectNew();
	}

	public void createSubOrg(String orgName, String orgCode) throws Exception {
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
	}

	public void switchToFrame(String frameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(frameName)));
	}

	// This function is to select organization form drop down
	public void selectDivision(String Division) throws Exception {
		switchToFrame("main");
		assertTrue(isElementPresent(By.name(selectDivision), driver));
		new Select(driver.findElement(By.name(selectDivision)))
				.selectByVisibleText(Division);
	}

	// This function is to enter organization and sub organization name
	public void enterOrgName(String orgName) throws Exception {
		switchToFrame("details");
		driver.findElement(By.name(orgNamefield)).clear();
		driver.findElement(By.name(orgNamefield)).sendKeys(orgName);
		assertEquals(orgName, driver.findElement(By.name(orgNamefield))
				.getAttribute("value"));
	}

	// This function is to enter organization and sub organization code
	public void enterCode(String orgCode) throws Exception {
		driver.findElement(By.name(orgCodefield)).clear();
		driver.findElement(By.name(orgCodefield)).sendKeys(orgCode);
		assertEquals(orgCode, driver.findElement(By.name(orgCodefield))
				.getAttribute("value"));
	}

	// This function is to save the changes
	public void selectSave() throws Exception {
		driver.findElement(By.name(savebutton)).click();
	}

	// This function is to select organization from results table
	public void selectOrg() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectOrg)).click();
	}

	// This function is to click on new option
	public void selectNew() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectNew)).click();
	}
}