package com.qsgsoft.Logicbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class HomePage extends WaitForElement{


	private static String selectCampusTab="_PCMM_TabText_5";
	private static String selectAdminFromDropdown = "//td[@id='_PCMM_ID_96_text']";


	public void SalesPerformancePage(WebDriver driver) throws Exception {
		driver.findElement(By.id(selectCampusTab)).click();
		driver.findElement(By.xpath(selectAdminFromDropdown)).click();
	}
}
