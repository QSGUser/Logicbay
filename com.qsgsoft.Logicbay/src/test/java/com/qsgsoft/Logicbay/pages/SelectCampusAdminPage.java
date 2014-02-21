package com.qsgsoft.Logicbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class SelectCampusAdminPage extends WaitForElement{
	private static String salesPerformanceCampus="//a[contains(@href, '../perfCtr/campus/frameset/frameset.jsp?campusId=1&switchCampus=true')]";
	//private static String salesPerformanceCampus="//a[contains(text(),'Sales Performance Campus')]";
	public void SelectCampusAdmin(WebDriver driver) throws Exception{ 
		//assertTrue(isElementPresent(By.xpath(salesPerformanceCampus),driver));
		driver.findElement(By.xpath(salesPerformanceCampus)).click();
	}
}