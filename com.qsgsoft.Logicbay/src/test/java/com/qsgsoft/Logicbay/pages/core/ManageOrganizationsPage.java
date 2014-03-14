package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import lib.WebElements;

public class ManageOrganizationsPage extends WebElements {
	private String selectDivision = "selRootOrgId", orgNamefield = "orgName",
			orgCodefield = "orgCode", savebutton = "save",
			selectNew = "//div[@id='dNewMenuItem']",
			selectOrg = "//div[@id='dResultTable']/table[1]",
			detailsFrameName = "details", 
			mainFramename = "main";
	public WebDriver driver;
	WebElement element;

	public ManageOrganizationsPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public ManageOrganizationsPage createOrg(String newOrg, String orgName,
			String orgCode) throws Exception {
		selectDivision(newOrg);
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
		return this;
	}

	public ManageOrganizationsPage selectCreatedOrg(String orgName)
			throws Exception {
		selectDivision(orgName);
		selectOrg();
		selectNew();
		return this;
	}

	public ManageOrganizationsPage createSubOrg(String orgName, String orgCode)
			throws Exception {
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
		return this;
	}

	// This function is to select organization form drop down
	public ManageOrganizationsPage selectDivision(String Division)
			throws Exception {
		switchToFrame(mainFramename, "id");
		assertTrue(isElementPresent(By.name(selectDivision)));
		element = element(selectDivision, "name");
		new Select(element).selectByVisibleText(Division);
		return this;
	}

	// This function is to enter organization and sub organization name
	public ManageOrganizationsPage enterOrgName(String orgName)
			throws Exception {
		switchToFrame(detailsFrameName, "id");
		element = element(orgNamefield, "name");
		element.clear();
		element.sendKeys(orgName);
		assertEquals(orgName, element.getAttribute("value"));
		return this;
	}

	// This function is to enter organization and sub organization code
	public ManageOrganizationsPage enterCode(String orgCode) throws Exception {
		element = element(orgCodefield, "name");
		element.clear();
		element.sendKeys(orgCode);
		assertEquals(orgCode, element.getAttribute("value"));
		return this;
	}

	// This function is to save the changes
	public ManageOrganizationsPage selectSave() throws Exception {
		element = element(savebutton, "name");
		element.click();
		return this;
	}

	// This function is to select organization from results table
	public ManageOrganizationsPage selectOrg() throws Exception {
		Thread.sleep(2000);
		element = element(selectOrg, "xpath");
		element.click();
		return this;
	}

	// This function is to click on new option
	public ManageOrganizationsPage selectNew() throws Exception {
		Thread.sleep(2000);
		element = element(selectNew, "xpath");
		element.click();
		return this;
	}
}