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
	private static String accept="//input[@name='okbutton']";
	private static String newpassword="new_password";
	private static String confirmnewpassword="confirm_new_password";
	private static String submitbutton="iSubmit";
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}

	public void login(WebDriver driver, String strUsername, String strPassword)
			throws Exception {
		enterUsername(driver, strUsername);
		enterPassword(driver, strPassword);
		clickLoginButton(driver);	
	}
	
	public void acceptAgreement(WebDriver driver) throws Exception{
		driver.findElement(By.xpath(accept));	
		driver.findElement(By.xpath(accept)).click();
	}
	
	public void enterNewPassword(WebDriver driver,String strnewPassword) throws Exception{
		driver.findElement(By.name(newpassword)).clear();
		driver.findElement(By.name(newpassword)).sendKeys(strnewPassword);
		assertEquals(strnewPassword, driver.findElement(By.name(newpassword)).getAttribute("value"));	
	}
	public void enterConfirmPassword(WebDriver driver,String strconfirmPassword)throws Exception{
		driver.findElement(By.name(confirmnewpassword)).clear();
		driver.findElement(By.name(confirmnewpassword)).sendKeys(strconfirmPassword);
		assertEquals(strconfirmPassword, driver.findElement(By.name(confirmnewpassword)).getAttribute("value"));	
	}
	
	public void selectSubmit(WebDriver driver)throws Exception{
		driver.findElement(By.id(submitbutton));	
		driver.findElement(By.id(submitbutton)).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();	
	}
	public void passwordReset(WebDriver driver,String strPassword,String strnewPassword)throws Exception{
		enterPassword(driver, strPassword);
		enterNewPassword(driver,strnewPassword);
		enterConfirmPassword(driver,strnewPassword);
		selectSubmit(driver);
	}
}
