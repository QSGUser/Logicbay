package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import lib.WebElements;

public class MembershipAdminPage extends WebElements {
	private String centerMembership = "//div[@id='tab_data_6']/table/tbody/tr[2]/td[1]",
			getItems = "//input[@name='btnGetItems']",
			selectSrc = "//select[@class='cListField'][@name='srcList']",
			checkTarget = "//form/table[3]/tbody/tr[2]/td[3]/select[@name='trgtList']",
			moveRight = "//input[@id='move_right']",
			selectSubmit = "//input[@type='button'][@value='Submit']",
			allowInheritance = "//input[@id='setAsInheritable'][@class='cInheritButton']",
			selectReturn = "//td[@class='cListControlPanel']/a",
			organizationMemebership = "//div[@id='tab_data_6']/table/tbody/tr[4]/td[1]",
			administeredMembership = "//div[@id='tab_data_6']/table/tbody/tr[10]/td[1]",
			keywordField = "keyword", selectsubType = "srctype";
	public WebDriver driver;
	WebElement element;

	public MembershipAdminPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public MembershipAdminPage selectcenterMembership() throws Exception {
		element = element(centerMembership, "xpath");
		element.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		return this;
	}

	public MembershipAdminPage verifyTarget() throws Exception {
		assertTrue(isElementPresent(By.xpath(checkTarget)));
		
		return this;
	}

	public MembershipAdminPage selectgetItems() throws Exception {
		Thread.sleep(2000);
		element = element(getItems, "xpath");
		element.click();
		return this;
	}

	public MembershipAdminPage selectSubmitOnMapping() throws Exception {
		Actions action = new Actions(driver);
		element = element(selectSubmit, "xpath");
		element.click();
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public MembershipAdminPage selectReturnOnMapping() throws Exception {
		Actions action = new Actions(driver);
		element = element(selectReturn, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public MembershipAdminPage selectsrcToMap(String src) throws Exception {
		assertTrue(isElementPresent(By.xpath(selectSrc)));
		element = element(selectSrc, "xpath");
		new Select(element).selectByVisibleText(src);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(src));
		return this;
	}

	public MembershipAdminPage selectMap() throws Exception {
		Thread.sleep(2000);
		element = element(moveRight, "xpath");
		element.click();
		return this;
	}

	public MembershipAdminPage selectorganizationMemebership(String subType,
			String src, String key) throws Exception {
		Thread.sleep(2000);
		element = element(organizationMemebership, "xpath");
		element.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public MembershipAdminPage enterKeyword(String key) throws Exception {
		element = element(keywordField, "name");
		element.clear();
		element.sendKeys(key);
		assertEquals(key, element.getAttribute("value"));
		return this;
	}

	public MembershipAdminPage selectsubType(String subType) throws Exception {
		assertTrue(isElementPresent(By.id(selectsubType)));
		element = element(selectsubType, "id");
		new Select(element).selectByVisibleText(subType);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(subType));
		return this;
	}

	public MembershipAdminPage selectAllowInheritance() throws Exception {
		Actions action = new Actions(driver);
		element = element(allowInheritance, "xpath");
		action.moveToElement(element)
				.click().build().perform();
		return this;
	}

	public MembershipAdminPage administeredMembership() throws Exception {
		Thread.sleep(2000);
		element = element(administeredMembership, "xpath");
		element.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public MembershipAdminPage MapToadministeredMembership(String subType,
			String src, String key) throws Exception {
		administeredMembership();
		selectsubType(subType);
		enterKeyword(key);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
		selectAllowInheritance();
		selectSubmitOnMapping();
		selectReturnOnMapping();
		return this;
	}

	public MembershipAdminPage MapToCenterMembership(String subType, String src)
			throws Exception {
		selectcenterMembership();
		selectsubType(subType);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
		selectSubmitOnMapping();
		selectReturnOnMapping();
		return this;
	}

	public MembershipAdminPage MapToOrgMembership(String subType, String src,
			String key) throws Exception {
		selectorganizationMemebership(subType, src, key);
		selectsubType(subType);
		enterKeyword(key);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
		selectSubmitOnMapping();
		selectReturnOnMapping();
		return this;
	}
}