package com.qsgsoft.Logicbay.pages;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.TestData;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class ContactCreationPage extends WaitForElement{
	TestData objTestData = new TestData();	
	private static String usernamefield="input[id='username']";
	private static String confirmUsernamefield="input[id='confirm_username']";
	private static String emailfield="input[id='email']";
	private static String confirmEmailfield="input[id='confirm_email']";
	private static String firstnamefield="input[id='first_name']";
	private static String lastnamefield="input[id='last_name']";
	private static String passwordfield="input[id='new_password;]";
	private static String confirmpasswordfield="input[id='confirm_new_password']";
	private static String mustresetpasswordfield="input[id=\"mustresetpassword\"][name=\"mustresetpassword\"][value=\"1\"][type=\"checkbox\"]'";
	private static String localefield="select[id='localeFK', name='localeFK']";
	
	public void enterContactDetails(WebDriver driver,String username,String confirmUsername,String emailAddress,String firstName,String lastName,String Password,String strLocale) throws Exception{
		enterusername(driver,username);
		enterConfirmUsername(driver,confirmUsername);
		enterEmail(driver,emailAddress);
		enterConfirmEmail(driver,emailAddress);
		enterFirstName(driver,firstName);
		enterLastName(driver,lastName);
		enterPassword(driver,Password);
		enterConfirmPassword(driver,Password);
	}	
	public void enterusername(WebDriver driver,String username) throws Exception{
		driver.findElement(By.xpath(usernamefield)).clear();
		driver.findElement(By.xpath(usernamefield)).sendKeys(username);
		assertEquals(username, driver.findElement(By.xpath(usernamefield)).getAttribute("value"));
	}
	public void enterConfirmUsername(WebDriver driver,String confirmUsername) throws Exception{
		driver.findElement(By.xpath(confirmUsernamefield)).clear();
		driver.findElement(By.xpath(confirmUsernamefield)).sendKeys(confirmUsername);
		assertEquals(confirmUsername, driver.findElement(By.xpath(confirmUsernamefield)).getAttribute("value"));
	}
	public void enterEmail(WebDriver driver,String emailAddress) throws Exception{
		driver.findElement(By.xpath(emailfield)).clear();
		driver.findElement(By.xpath(emailfield)).sendKeys(emailAddress);
		assertEquals(emailAddress, driver.findElement(By.xpath(emailfield)).getAttribute("value"));
	}
	public void enterConfirmEmail(WebDriver driver,String emailAddress) throws Exception{
		driver.findElement(By.xpath(confirmEmailfield)).clear();
		driver.findElement(By.xpath(confirmEmailfield)).sendKeys(emailAddress);
		assertEquals(confirmEmailfield, driver.findElement(By.xpath(emailAddress)).getAttribute("value"));
	}
	public void enterFirstName(WebDriver driver,String firstName)throws Exception{
		driver.findElement(By.xpath(firstnamefield)).clear();
		driver.findElement(By.xpath(firstnamefield)).sendKeys(firstName);
		assertEquals(firstName, driver.findElement(By.xpath(firstnamefield)).getAttribute("value"));
	}
	public void enterLastName(WebDriver driver,String lastName)throws Exception{
		driver.findElement(By.xpath(lastnamefield)).clear();
		driver.findElement(By.xpath(lastnamefield)).sendKeys(lastName);
		assertEquals(lastName, driver.findElement(By.xpath(lastnamefield)).getAttribute("value"));
	}
	public void enterPassword(WebDriver driver,String Password)throws Exception{
		driver.findElement(By.xpath(passwordfield)).clear();
		driver.findElement(By.xpath(passwordfield)).sendKeys(Password);
		assertEquals(Password, driver.findElement(By.xpath(passwordfield)).getAttribute("value"));	
	}
	public void enterConfirmPassword(WebDriver driver,String Password)throws Exception{
		driver.findElement(By.xpath(confirmpasswordfield)).clear();
		driver.findElement(By.xpath(confirmpasswordfield)).sendKeys(Password);
		assertEquals(Password, driver.findElement(By.xpath(confirmpasswordfield)).getAttribute("value"));	
	}	
}