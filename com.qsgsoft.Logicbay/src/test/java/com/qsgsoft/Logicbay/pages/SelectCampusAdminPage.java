package com.qsgsoft.Logicbay.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class SelectCampusAdminPage extends WaitForElement{


	private static String salesPerformanceCampus="//a[contains(@href, '../perfCtr/campus/frameset/frameset.jsp?campusId=1&switchCampus=true')]";
	
	public void SelectCampusAdmin(WebDriver driver) throws Exception{ 
		driver.findElement(By.xpath(salesPerformanceCampus)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
