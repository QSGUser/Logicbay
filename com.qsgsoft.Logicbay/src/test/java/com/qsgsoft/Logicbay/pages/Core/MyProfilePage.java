package com.qsgsoft.Logicbay.pages.Core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.qsgsoft.Logicbay.modules.DashboardFunctions;
import static org.junit.Assert.*;

public class MyProfilePage extends DashboardFunctions{
	
	private static String profileText="//form[@id='regform']/table/tbody/tr[2]";
	
	public void verifyUser(WebDriver driver,String userename) throws Exception{
		String profileName = driver.findElement(By.xpath(profileText)).getText();	
		assertEquals(profileName, userename);
	}

}


