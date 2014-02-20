package com.qsgsoft.Logicbay.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;


public class LoginPage extends WaitForElement{

	private static String username="input[name=\"username\"]";
	private static String password="input[name=\"password\"]";
	private static String loginbutton="input[type=\"submit\"]";
	private static String url="https://dpcstage.logicbay.com/dlms/login/landing.jsp?backdoor=yes";

	public void launchURL(WebDriver driver) throws Exception {
		driver.get(url);
		waitForElement(driver, username);
		assertTrue(isElementPresent(By.cssSelector(username), driver));
	}

	public void enterUsername(WebDriver driver, String strUsername)
			throws Exception {
		waitForElement(driver, username);
		driver.findElement(By.cssSelector(username)).clear();
		driver.findElement(By.cssSelector(username)).sendKeys(strUsername);
		assertEquals(strUsername, driver.findElement(By.cssSelector(username))
				.getAttribute("value"));
	}

	public void enterPassword(WebDriver driver,String strPassword) throws Exception{
		waitForElement(driver,password);
		driver.findElement(By.cssSelector(password)).clear();
		driver.findElement(By.cssSelector(password)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.cssSelector(password)).getAttribute("value"));
	}

	public void clickLoginButton(WebDriver driver) throws Exception{
		waitForElement(driver, loginbutton);
		driver.findElement(By.cssSelector(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}


	public void login(WebDriver driver, String strUsername, String strPassword)
			throws Exception {
		enterUsername(driver, strUsername);
		enterPassword(driver, strPassword);
		clickLoginButton(driver);	
	}





}
