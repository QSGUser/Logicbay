package com.qsgsoft.Logicbay.pages.Core;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.TestData;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class UserPage extends WaitForElement{
	TestData objTestData = new TestData();	
	private static String usernamefield="username";
	private static String confirmUsernamefield="confirm_username";
	private static String emailfield="email";
	private static String confirmEmailfield="confirm_email";
	private static String firstnamefield="first_name";
	private static String lastnamefield="last_name";
	private static String passwordfield="new_password";
	private static String confirmpasswordfield="confirm_new_password";
	private static String localefield="localeFK";
	private static String timezone="timezone";
	private static String generalTab="tab_1";
	private static String statusTab= "tab_2";
	private static String settingsTab="tab_3";
	private static String AffiliationsTab="tab_6";
	private static String memberStatus="approvalStatus";
	private static String systemRole="role";
	private static String jobRole="job";
	private static String jobtitle="empType";
	private static String savebutton="saveGroup";
	private static String gender="//input[@type='radio']";
	
	
	public void switchToGeneralTab(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.switchTo().window("");	
		driver.switchTo().frame(driver.findElement(By.id("main")));		
		driver.findElement(By.id(generalTab));
		action.moveToElement(driver.findElement(By.id(generalTab))).click().build().perform();		
	}
	
	public void switchToStatusTab(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElement(By.id(statusTab));
		action.moveToElement(driver.findElement(By.id(statusTab))).click().build().perform();		
	}
	
	public void switchToSettingsTab(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElement(By.id(settingsTab));
		action.moveToElement(driver.findElement(By.id(settingsTab))).click().build().perform();		
	}
	public void switchToAffiliationsTab(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElement(By.id(AffiliationsTab)).click();
		action.moveToElement(driver.findElement(By.id(AffiliationsTab))).click().build().perform();		
	}
	
	public void enterusername(WebDriver driver,String username) throws Exception{
		driver.findElement(By.id(usernamefield)).clear();
		driver.findElement(By.id(usernamefield)).sendKeys(username);
		assertEquals(username, driver.findElement(By.id(usernamefield)).getAttribute("value"));
	}
	public void enterConfirmUsername(WebDriver driver,String confirmUsername) throws Exception{
		driver.findElement(By.id(confirmUsernamefield)).clear();
		driver.findElement(By.id(confirmUsernamefield)).sendKeys(confirmUsername);
		assertEquals(confirmUsername, driver.findElement(By.id(confirmUsernamefield)).getAttribute("value"));
	}
	public void enterEmail(WebDriver driver,String emailAddress) throws Exception{
		driver.findElement(By.id(emailfield)).clear();
		driver.findElement(By.id(emailfield)).sendKeys(emailAddress);
		assertEquals(emailAddress, driver.findElement(By.id(emailfield)).getAttribute("value"));
	}
	public void enterConfirmEmail(WebDriver driver,String emailAddress) throws Exception{
		driver.findElement(By.id(confirmEmailfield)).clear();
		driver.findElement(By.id(confirmEmailfield)).sendKeys(emailAddress);
		assertEquals(emailAddress, driver.findElement(By.id(confirmEmailfield)).getAttribute("value"));
	}
	public void enterFirstName(WebDriver driver,String firstName)throws Exception{
		driver.findElement(By.id(firstnamefield)).clear();
		driver.findElement(By.id(firstnamefield)).sendKeys(firstName);
		assertEquals(firstName, driver.findElement(By.id(firstnamefield)).getAttribute("value"));
	}
	public void enterLastName(WebDriver driver,String lastName)throws Exception{
		driver.findElement(By.id(lastnamefield)).clear();
		driver.findElement(By.id(lastnamefield)).sendKeys(lastName);
		assertEquals(lastName, driver.findElement(By.id(lastnamefield)).getAttribute("value"));
	}
	public void enterPassword(WebDriver driver,String password)throws Exception{
		driver.findElement(By.id(passwordfield)).clear();
		driver.findElement(By.id(passwordfield)).sendKeys(password);
		assertEquals(password, driver.findElement(By.id(passwordfield)).getAttribute("value"));	
	}
	public void enterConfirmPassword(WebDriver driver,String password)throws Exception{
		driver.findElement(By.id(confirmpasswordfield)).clear();
		driver.findElement(By.id(confirmpasswordfield)).sendKeys(password);
		assertEquals(password, driver.findElement(By.id(confirmpasswordfield)).getAttribute("value"));	
	}
	
	public void selectTimeZone(WebDriver driver,String TimeZone) throws Exception{		
		assertTrue(isElementPresent(By.id(timezone), driver));
		new Select(driver.findElement(By.id(timezone))).selectByVisibleText(TimeZone);
		String strSelectedVal = new Select(driver.findElement(By.id(timezone))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(TimeZone));
	}
	public void selectLocale(WebDriver driver,String Locale) throws Exception{
		assertTrue(isElementPresent(By.id(localefield), driver));
		new Select(driver.findElement(By.id(localefield))).selectByVisibleText(Locale);
		String strSelectedVal = new Select(driver.findElement(By.id(localefield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(Locale));
	}
	
	public void selectMemberStatus(WebDriver driver,String MemberStatus) throws Exception{
		assertTrue(isElementPresent(By.id(memberStatus), driver));
		new Select(driver.findElement(By.id(memberStatus))).selectByVisibleText(MemberStatus);
		String strSelectedVal = new Select(driver.findElement(By.id(memberStatus))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(MemberStatus));	
	}
	public void selectSystemRole(WebDriver driver,String SystemRole) throws Exception{
		assertTrue(isElementPresent(By.id(systemRole), driver));
		new Select(driver.findElement(By.id(systemRole))).selectByVisibleText(SystemRole);
		String strSelectedVal = new Select(driver.findElement(By.id(systemRole))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(SystemRole));	
	}
	
	public void selectJobRole(WebDriver driver,String JobRole) throws Exception{
		assertTrue(isElementPresent(By.id(jobRole), driver));
		new Select(driver.findElement(By.id(jobRole))).selectByVisibleText(JobRole);
		String strSelectedVal = new Select(driver.findElement(By.id(jobRole))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(JobRole));	
	}
	
	public void enterJobTitle(WebDriver driver,String JobTitle)throws Exception{
		driver.findElement(By.id(jobtitle)).clear();
		driver.findElement(By.id(jobtitle)).sendKeys(JobTitle);
		assertEquals(JobTitle, driver.findElement(By.id(jobtitle)).getAttribute("value"));	
	}
	
	public void selectSave(WebDriver driver) throws Exception{
		driver.findElement(By.id(savebutton)).click();	
		driver.switchTo().alert().accept();	
		Thread.sleep(1000);
		driver.switchTo().alert().accept();		
	}
	
	public void selectGender(WebDriver driver, String genderType) throws Exception{
		driver.findElement(By.xpath(gender));
		driver.findElement(By.xpath(gender)).click();
	}
	
	public void AddUser(WebDriver driver,String userName,String emailAddress,String firstName,String lastName,String password,String timeZone,String locale,String MemberStatus,String SystemRole,String JobRole,String genderType)throws Exception{
		switchToGeneralTab(driver);
		enterusername(driver,userName);
		enterConfirmUsername(driver,userName);
		enterEmail(driver,emailAddress);
		enterConfirmEmail(driver,emailAddress);
		enterFirstName(driver,firstName);
		enterLastName(driver,lastName);
		enterPassword(driver,password);
		enterConfirmPassword(driver,password);
		selectTimeZone(driver,timeZone);
		selectLocale(driver,locale);
		selectGender(driver,genderType);
		switchToStatusTab(driver);
		selectMemberStatus(driver,MemberStatus);
		switchToSettingsTab(driver);
		selectSystemRole(driver,SystemRole);
		selectJobRole(driver,JobRole);
		selectSave(driver);
		switchToAffiliationsTab(driver);	
	}
}