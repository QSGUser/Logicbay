package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class ManageOrganizationsPage extends WaitForElement {
	private static String selectDivisionfield = "selRootOrgId";
	private static String orgNamefield = "orgName";
	private static String orgCodefield = "orgCode";
	private static String savebutton = "save";
	private static String selectNew = "//td[@id='tdNewMenuItem']/div/a/img[@src='../perfCtr/campus/images/admin/controls/document.gif']";
	private static String selectOrg = "//i";
	public WebDriver driver;

	public ManageOrganizationsPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void createOrg(String orgName, String orgCode) throws Exception {
		selectDivision("*** Create New Division ***");
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
	}

	public void createSubOrg(String orgName, String orgCode) throws Exception {
		enterOrgName(orgName);
		enterCode(orgCode);
		selectSave();
	}

	public void selectCreatedOrg(String orgName) throws Exception {
		selectDivision(orgName);
		selectOrg();
		selectNew();
	}

	public void switchToFrame(String frameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(frameName)));
	}

	public void selectDivision(String Division) throws Exception {
		switchToFrame("main");
		assertTrue(isElementPresent(By.name(selectDivisionfield), driver));
		new Select(driver.findElement(By.name(selectDivisionfield)))
				.selectByVisibleText(Division);
		String strSelectedVal = new Select(driver.findElement(By
				.name(selectDivisionfield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(Division));
	}

	public void enterOrgName(String orgName) throws Exception {
		switchToFrame("details");
		driver.findElement(By.name(orgNamefield)).clear();
		driver.findElement(By.name(orgNamefield)).sendKeys(orgName);
		assertEquals(orgName, driver.findElement(By.name(orgNamefield))
				.getAttribute("value"));

	}

	public void enterCode(String orgCode) throws Exception {
		driver.findElement(By.name(orgCodefield)).clear();
		driver.findElement(By.name(orgCodefield)).sendKeys(orgCode);
		assertEquals(orgCode, driver.findElement(By.name(orgCodefield))
				.getAttribute("value"));
	}

	public void selectSave() throws Exception {
		driver.findElement(By.name(savebutton)).click();
	}

	public void selectOrg() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectOrg)).click();
	}

	public void selectNew() throws Exception {
		driver.findElement(By.xpath(selectNew)).click();
	}
}