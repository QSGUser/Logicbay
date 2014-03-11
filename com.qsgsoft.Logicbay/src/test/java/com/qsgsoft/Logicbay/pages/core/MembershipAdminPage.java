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
			organizationMembership = "//div[@id='tab_data_6']/table/tbody/tr[4]/td[1]",
			getItems = "//input[@name='btnGetItems']",
			selectSrc = "//select[@class='cListField'][@name='srcList']",
			checkTarget = "//form/table[3]/tbody/tr[2]/td[3]/select[@name='trgtList']",
			moveRight = "//input[@id='move_right']",
			selectSubmit = "//input[@type='button'][@value='Submit']",
			selectReturn = "//td[@class='cListControlPanel']/a",
			organizationMemebership = "//div[@id='tab_data_6']/table/tbody/tr[4]/td[1]",
			selectsubType = "srctype";
	public WebDriver driver;

	public MembershipAdminPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void switchToFrame(String FrameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(FrameName)));
	}

	public void selectcenterMembership(String subType, String src)
			throws Exception {
		driver.findElement(By.xpath(centerMembership)).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		selectsubType(subType);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
	}

	public void verifyTarget() throws Exception {
		assertTrue(isElementPresent(By.xpath(checkTarget), driver));
	}

	public void selectgetItems() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(getItems));
		driver.findElement(By.xpath(getItems)).click();
	}

	public void selectorganziationMembership() throws Exception {
		driver.findElement(By.xpath(organizationMembership)).click();
		driver.switchTo().alert().accept();
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

	public void selectorganizationMemebership(String subType, String src)
			throws Exception {
		driver.findElement(By.xpath(organizationMemebership)).click();
		driver.switchTo().alert().accept();
		selectsubType(subType);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		assertTrue(isElementPresent(By.xpath(checkTarget), driver));
	}

	public void selectsubType(String subType) throws Exception {
		assertTrue(isElementPresent(By.id(selectsubType), driver));
		new Select(driver.findElement(By.id(selectsubType)))
				.selectByVisibleText(subType);
		String strSelectedVal = new Select(driver.findElement(By
				.id(selectsubType))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(subType));
	}

	public void MapToCenterMembership(String strcentersubType,
			String strcenterSrc) throws Exception {
		selectcenterMembership(strcentersubType, strcenterSrc);
		selectSubmitOnMapping();
		selectReturnOnMapping();
	}

}