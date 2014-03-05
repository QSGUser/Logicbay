package com.qsgsoft.Logicbay.pages.daimler;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UserPage extends com.qsgsoft.Logicbay.pages.core.UserPage {

	private static String usernamefield = "usernameMode";
	private static String accountfield = "accountUsed";
	public static WebDriver driver;

	public UserPage(WebDriver _driver) {
		super(_driver);
		UserPage.driver = _driver;
	}

	public void AddUser(String userName, String emailAddress,
			String firstName, String middleName, String lastName,
			String password, String technicalId, String timeZone,
			String locale, String memberStatus, String systemRole,
			String jobRole, String associatedAccount) throws Exception {
		this.switchToGeneralTab();
		this.selectUserName(userName);
		this.enterEmail(emailAddress);
		this.enterConfirmEmail(emailAddress);
		this.enterFirstName(firstName);
		this.enterMiddleName(middleName);
		this.enterLastName(lastName);
		this.enterPassword(password);
		this.enterConfirmPassword(password);
		this.enterTechOrEmpID(technicalId);
		this.selectTimeZone(timeZone);
		this.selectLocale(locale);
		this.switchToStatusTab();
		this.selectMemberStatus(memberStatus);
		this.switchToSettingsTab();
		this.selectSystemRole(systemRole);
		this.selectJobRole(jobRole);
		this.selectAccount(associatedAccount);
		this.selectSave();
		this.switchToAffiliationsTab();
	}

	public void selectUserName(String UserName) throws Exception {
		assertTrue(isElementPresent(By.id(usernamefield), driver));
		new Select(driver.findElement(By.id(usernamefield)))
				.selectByVisibleText(UserName);
		String strSelectedVal = new Select(driver.findElement(By
				.id(usernamefield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(UserName));
	}

	public void selectAccount(String associatedAccount) throws Exception {
		assertTrue(isElementPresent(By.id(accountfield), driver));
		new Select(driver.findElement(By.id(accountfield)))
				.selectByVisibleText(associatedAccount);
		String strSelectedVal = new Select(driver.findElement(By
				.id(accountfield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(associatedAccount));
	}
}