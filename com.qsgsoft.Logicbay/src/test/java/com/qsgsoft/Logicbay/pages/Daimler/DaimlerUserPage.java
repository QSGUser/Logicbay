package com.qsgsoft.Logicbay.pages.Daimler;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qsgsoft.Logicbay.pages.Core.UserPage;

public class DaimlerUserPage extends UserPage{
	private static String usernamefield="usernameMode";
	private static String accountfield="accountUsed";
	
	public void DaimlerUserCreation(WebDriver driver,String userName,String emailAddress,String firstName,String middleName,String lastName,String password,String technicalId,String timeZone,String locale,String memberStatus,String systemRole,String jobRole,String associatedAccount) throws Exception{
		switchToGeneralTab(driver);
		selectUserName(driver,userName);
		enterEmail(driver,emailAddress);
		enterConfirmEmail(driver,emailAddress);
		enterFirstName(driver,firstName);
		enterMiddleName(driver,middleName);
		enterLastName(driver,lastName);
		enterPassword(driver,password);
		enterConfirmPassword(driver,password);
		enterTechOrEmpID(driver,technicalId);
		selectTimeZone(driver,timeZone);
		selectLocale(driver,locale);
		switchToStatusTab(driver);
		selectMemberStatus(driver,memberStatus);
		switchToSettingsTab(driver);
		selectSystemRole(driver,systemRole);
		selectJobRole(driver,jobRole);	
		selectAccount(driver,associatedAccount);
		selectSave(driver);
		switchToAffiliationsTab(driver);	
	}
	
	public void selectUserName(WebDriver driver,String UserName) throws Exception{
		assertTrue(isElementPresent(By.id(usernamefield), driver));
		new Select(driver.findElement(By.id(usernamefield))).selectByVisibleText(UserName);
		String strSelectedVal = new Select(driver.findElement(By.id(usernamefield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(UserName));	
	}
	public void selectAccount(WebDriver driver,String associatedAccount) throws Exception{
		assertTrue(isElementPresent(By.id(accountfield), driver));
		new Select(driver.findElement(By.id(accountfield))).selectByVisibleText(associatedAccount);
		String strSelectedVal = new Select(driver.findElement(By.id(accountfield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(associatedAccount));	
	}
}
