package com.qsgsoft.Logicbay.pages;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class AdminPage extends WaitForElement{
		private static String selectUsers="img[id=\"catBullet6\"][src=\"..>images>admin>icons>plus.gif\"]";
		private static String selectAddUsers="td[id='addLTUser']";
	
		public void SelectUserAdmin(WebDriver driver) throws Exception{		
			selectUser(driver);
			selectAddUser(driver);
		}	
		
		public void selectUser(WebDriver driver) throws Exception{
			assertTrue(isElementPresent(By.cssSelector("selectUsers"), driver));
			driver.findElement(By.cssSelector(selectUsers)).click();	
		}
		public void selectAddUser(WebDriver driver) throws Exception{
			assertTrue(isElementPresent(By.cssSelector(selectAddUsers),driver));
			driver.findElement(By.cssSelector(selectAddUsers)).click();	
		}
}