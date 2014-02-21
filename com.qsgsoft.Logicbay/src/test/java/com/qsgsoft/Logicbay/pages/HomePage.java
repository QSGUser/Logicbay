package com.qsgsoft.Logicbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class HomePage extends WaitForElement{
	private static String selectCampusTab="//tr[@id='javascriptMenuTop']/td[6]";

	public void SalesPerformancePage(WebDriver driver) throws Exception {
		driver.findElement(By.cssSelector(selectCampusTab)).click();
	}
}
