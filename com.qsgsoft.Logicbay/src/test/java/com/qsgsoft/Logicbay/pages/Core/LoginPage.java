package com.qsgsoft.Logicbay.pages.Core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class LoginPage extends WaitForElement {
	private static String username="username";
	private static String password="password";
	private static String loginbutton="cmdLogin";
	
	public void launchURL(WebDriver driver,String url) throws Exception {
		driver.get(url);
		assertTrue(isElementPresent(By.name(username), driver));
	}
	public void enterUsername(WebDriver driver, String strUsername)
			throws Exception {
		driver.findElement(By.name(username)).clear();
		driver.findElement(By.name(username)).sendKeys(strUsername);
		assertEquals(strUsername, driver.findElement(By.name(username))
				.getAttribute("value"));
	}
	public void enterPassword(WebDriver driver,String strPassword) throws Exception{
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.name(password)).getAttribute("value"));
	}

	public void clickLoginButton(WebDriver driver) throws Exception{
		driver.findElement(By.id(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);		
	}

	public void login(WebDriver driver, String strUsername, String strPassword)
			throws Exception {
		enterUsername(driver, strUsername);
		enterPassword(driver, strPassword);
		clickLoginButton(driver);	
	}
	
}
