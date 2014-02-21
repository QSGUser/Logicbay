package com.qsgsoft.Logicbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class HomePage extends WaitForElement{
	private static String selectCampusTab="//tr[@id='javascriptMenuTop']/td[6]";
	private static String selectAdmin="td[id=\"_PCMM_ID_96_text\"][class=\"Menu_DynamicRule2\"]";
	
	public void SalesPerformancePage(WebDriver driver) throws Exception {
		selectCampus(driver);
		selectAdmin(driver);
	}
	public void selectCampus(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		ExpectedCondition<WebDriver> w=(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topFrame"));	
		//Wait=driver.switchTo().frame("topFrame");
		driver.switchTo().frame("topFrame");
		assertTrue(isElementPresent(By.xpath(selectCampusTab), driver));
		action.moveToElement(driver.findElement(By.xpath(selectCampusTab))).click();
	}
	public void selectAdmin(WebDriver driver) throws Exception{
		//assertTrue(isElementPresent(By.xpath(selectAdmin), driver));
		String strSelectedVal = new Select(driver.findElement(By
				.xpath(selectAdmin))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals("Admin"));
	}
}