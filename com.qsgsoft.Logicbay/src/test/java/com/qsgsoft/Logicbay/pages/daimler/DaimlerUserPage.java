package com.qsgsoft.Logicbay.pages.daimler;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.pages.core.UserPage;

public class DaimlerUserPage extends UserPage {

	private static String usernamefield = "usernameMode";
	private static String accountfield = "accountUsed";
	public static WebDriver driver;

	public DaimlerUserPage(WebDriver _driver) {
		super(_driver);
		DaimlerUserPage.driver = _driver;
	}

	public void AddUser(String userName, String emailAddress,
			String firstName, String middleName, String lastName,
			String password, String technicalId, String timeZone,
			String locale, String memberStatus, String systemRole,
			String jobRole, String associatedAccount) throws Exception {
		this.switchToGeneralTab();
		selectUserName(userName);
		enterEmail(emailAddress);
		enterConfirmEmail(emailAddress);
		enterFirstName(firstName);
		enterMiddleName(middleName);
		enterLastName(lastName);
		enterPassword(password);
		enterConfirmPassword(password);
		enterTechOrEmpID(technicalId);
		selectTimeZone(timeZone);
		selectLocale(locale);
		switchToStatusTab();
		selectMemberStatus(memberStatus);
		switchToSettingsTab();
		selectSystemRole(systemRole);
		selectJobRole(jobRole);
		selectAccount(associatedAccount);
		selectSave();
		switchToAffiliationsTab();
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