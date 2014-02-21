package com.qsgsoft.Logicbay.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class AdminPage extends WaitForElement{
		private static String selectUsers="td[class='cAdminMenuHeading'][onclick='toggleCat(6)']";
		private static String selectAddUsers="";
	
	public void ClickOnAddUser(WebDriver driver) throws Exception{
		assertTrue(isElementPresent(By.cssSelector("selectUsers"), driver));		
		
	}	
}
