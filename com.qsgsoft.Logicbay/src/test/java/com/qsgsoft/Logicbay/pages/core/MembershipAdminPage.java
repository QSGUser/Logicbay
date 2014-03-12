package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class MembershipAdminPage extends WaitForElement {
	private String centerMembership = "//div[@id='tab_data_6']/table/tbody/tr[2]/td[1]",
			getItems = "//input[@name='btnGetItems']",
			selectSrc = "//select[@class='cListField'][@name='srcList']",
			checkTarget = "//form/table[3]/tbody/tr[2]/td[3]/select[@name='trgtList']",
			moveRight = "//input[@id='move_right']",
			selectSubmit = "//input[@type='button'][@value='Submit']",
			allowInheritance="//input[@id='setAsInheritable'][@class='cInheritButton']",
			selectReturn = "//td[@class='cListControlPanel']/a",
			organizationMemebership = "//div[@id='tab_data_6']/table/tbody/tr[4]/td[1]",
			administeredMembership="//div[@id='tab_data_6']/table/tbody/tr[10]/td[1]",
			keywordField="keyword",
			selectsubType = "srctype";
	public WebDriver driver;

	public MembershipAdminPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void switchToFrame(String FrameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(FrameName)));
	}

	public void selectcenterMembership()
			throws Exception {
		driver.findElement(By.xpath(centerMembership)).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
		
	public void verifyTarget() throws Exception {
		assertTrue(isElementPresent(By.xpath(checkTarget), driver));
	}

	public void selectgetItems() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(getItems));
		driver.findElement(By.xpath(getItems)).click();
	}

	public void selectSubmitOnMapping() throws Exception {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(selectSubmit));
		action.moveToElement(driver.findElement(By.xpath(selectSubmit)))
				.click().build().perform();
	}

	public void selectReturnOnMapping() throws Exception {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(selectReturn));
		action.moveToElement(driver.findElement(By.xpath(selectReturn)))
				.click().build().perform();
	}

	public void selectsrcToMap(String src) throws Exception {
		assertTrue(isElementPresent(By.xpath(selectSrc), driver));
		new Select(driver.findElement(By.xpath(selectSrc)))
				.selectByVisibleText(src);
		String strSelectedVal = new Select(driver.findElement(By
				.xpath(selectSrc))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(src));
	}

	public void selectMap() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(moveRight));
		driver.findElement(By.xpath(moveRight)).click();
	}

	public void selectorganizationMemebership(String subType, String src,String key)
			throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(organizationMemebership)).click();
		driver.switchTo().alert().accept();
		selectsubType(subType);
		enterKeyword(key);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
	}
	
	public void enterKeyword(String key)throws Exception{
		driver.findElement(By.name(keywordField)).clear();
		driver.findElement(By.name(keywordField)).sendKeys(key);
		assertEquals(key, driver.findElement(By.name(keywordField))
				.getAttribute("value"));
	}

	public void selectsubType(String subType) throws Exception {
		assertTrue(isElementPresent(By.id(selectsubType), driver));
		new Select(driver.findElement(By.id(selectsubType)))
				.selectByVisibleText(subType);
		String strSelectedVal = new Select(driver.findElement(By
				.id(selectsubType))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(subType));
	}

	public void selectAllowInheritance()throws Exception{
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(allowInheritance));
		action.moveToElement(driver.findElement(By.xpath(allowInheritance)))
				.click().build().perform();	
	}

	public void administeredMembership()throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.xpath(administeredMembership)).click();
		driver.switchTo().alert().accept();
	}
	
	public void MapToadministeredMembership(String subType, String src,String key)throws Exception{
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
	}
	public MembershipAdminPage MapToCenterMembership(String subType, String src) throws Exception {
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
	public void MapToOrgMembership(String subType, String src,String key)throws Exception{
		selectorganizationMemebership(subType,src,key);
		selectSubmitOnMapping();
		selectReturnOnMapping();
	}
	
}