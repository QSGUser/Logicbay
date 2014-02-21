package com.qsgsoft.Logicbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class SelectCampusAdminPage extends WaitForElement{
	private static String salesPerformanceCampus="//a[@href='../perfCtr/campus/frameset/frameset.jsp?campusId=1&switchCampus=true']";
	public void SelectCampusAdmin(WebDriver driver) throws Exception{ 
		assertTrue(isElementPresent(By.xpath(salesPerformanceCampus),driver));
		driver.findElement(By.xpath(salesPerformanceCampus)).click();
	}
}