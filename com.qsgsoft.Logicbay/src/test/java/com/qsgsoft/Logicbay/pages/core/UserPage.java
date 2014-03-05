package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.TestData;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class UserPage extends WaitForElement {
	TestData objTestData = new TestData();
	private static String usernamefield = "username";
	private static String confirmUsernamefield = "confirm_username";
	private static String emailfield = "email";
	private static String confirmEmailfield = "confirm_email";
	private static String salutationfield="salutation";
	private static String firstnamefield = "first_name";
	private static String middlenamefield = "middle_name";
	private static String lastnamefield = "last_name";
	private static String passwordfield = "new_password";
	private static String confirmpasswordfield = "confirm_new_password";
	private static String employeeIdfield = "employee_id";
	private static String localefield = "localeFK";
	private static String timezone = "timezone";
	private static String generalTab = "tab_1";
	private static String statusTab = "tab_2";
	private static String settingsTab = "tab_3";
	private static String AffiliationsTab = "tab_6";
	private static String memberStatus = "approvalStatus";
	private static String systemRole = "role";
	private static String jobRole = "job";
	private static String jobtitle = "empType";
	private static String savebutton = "saveGroup";
	private static String gender = "//input[@type='radio']";

	public WebDriver driver;

	public UserPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void switchToGeneralTab() throws Exception {
		Actions action = new Actions(driver);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("main")));
		driver.findElement(By.id(generalTab));
		action.moveToElement(driver.findElement(By.id(generalTab))).click()
		.build().perform();
	}

	public void switchToStatusTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(statusTab));
		action.moveToElement(driver.findElement(By.id(statusTab))).click()
		.build().perform();
	}

	public void switchToSettingsTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(settingsTab));
		action.moveToElement(driver.findElement(By.id(settingsTab))).click()
		.build().perform();
	}

	public void switchToAffiliationsTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(AffiliationsTab)).click();
		action.moveToElement(driver.findElement(By.id(AffiliationsTab)))
		.click().build().perform();
	}

	public void enterusername(String username) throws Exception {
		driver.findElement(By.id(usernamefield)).clear();
		driver.findElement(By.id(usernamefield)).sendKeys(username);
		assertEquals(username, driver.findElement(By.id(usernamefield))
				.getAttribute("value"));
	}

	public void enterConfirmUsername(String confirmUsername) throws Exception {
		driver.findElement(By.id(confirmUsernamefield)).clear();
		driver.findElement(By.id(confirmUsernamefield)).sendKeys(
				confirmUsername);
		assertEquals(
				confirmUsername,
				driver.findElement(By.id(confirmUsernamefield)).getAttribute(
						"value"));
	}

	public void enterEmail(String emailAddress) throws Exception {
		driver.findElement(By.id(emailfield)).clear();
		driver.findElement(By.id(emailfield)).sendKeys(emailAddress);
		assertEquals(emailAddress, driver.findElement(By.id(emailfield))
				.getAttribute("value"));
	}

	public void enterConfirmEmail(String emailAddress) throws Exception {
		driver.findElement(By.id(confirmEmailfield)).clear();
		driver.findElement(By.id(confirmEmailfield)).sendKeys(emailAddress);
		assertEquals(emailAddress, driver.findElement(By.id(confirmEmailfield))
				.getAttribute("value"));
	}
	
	public void selectSalutation(String salutation) throws Exception {
		assertTrue(isElementPresent(By.name(salutationfield), driver));
		new Select(driver.findElement(By.name(salutationfield)))
		.selectByVisibleText(salutation);
		String strSelectedVal = new Select(
				driver.findElement(By.name(salutationfield))).getFirstSelectedOption()
				.getText();
		assertTrue(strSelectedVal.equals(salutation));
	}

	public void enterFirstName(String firstName) throws Exception {
		driver.findElement(By.id(firstnamefield)).clear();
		driver.findElement(By.id(firstnamefield)).sendKeys(firstName);
		assertEquals(firstName, driver.findElement(By.id(firstnamefield))
				.getAttribute("value"));
	}

	public void enterMiddleName(String middleName) throws Exception {
		driver.findElement(By.id(middlenamefield)).clear();
		driver.findElement(By.id(middlenamefield)).sendKeys(middleName);
		assertEquals(middleName, driver.findElement(By.id(middlenamefield))
				.getAttribute("value"));
	}

	public void enterLastName(String lastName) throws Exception {
		driver.findElement(By.id(lastnamefield)).clear();
		driver.findElement(By.id(lastnamefield)).sendKeys(lastName);
		assertEquals(lastName, driver.findElement(By.id(lastnamefield))
				.getAttribute("value"));
	}

	public void enterPassword(String password) throws Exception {
		driver.findElement(By.id(passwordfield)).clear();
		driver.findElement(By.id(passwordfield)).sendKeys(password);
		assertEquals(password, driver.findElement(By.id(passwordfield))
				.getAttribute("value"));
	}

	public void enterConfirmPassword(String password) throws Exception {
		driver.findElement(By.id(confirmpasswordfield)).clear();
		driver.findElement(By.id(confirmpasswordfield)).sendKeys(password);
		assertEquals(password, driver.findElement(By.id(confirmpasswordfield))
				.getAttribute("value"));
	}

	public void enterTechOrEmpID(String ID) throws Exception {
		driver.findElement(By.id(employeeIdfield)).clear();
		driver.findElement(By.id(employeeIdfield)).sendKeys(ID);
		assertEquals(ID, driver.findElement(By.id(employeeIdfield))
				.getAttribute("value"));
	}

	public void selectTimeZone(String TimeZone) throws Exception {
		assertTrue(isElementPresent(By.name(timezone), driver));
		new Select(driver.findElement(By.name(timezone)))
		.selectByVisibleText(TimeZone);
		String strSelectedVal = new Select(
				driver.findElement(By.name(timezone))).getFirstSelectedOption()
				.getText();
		assertTrue(strSelectedVal.equals(TimeZone));
	}

	public void selectLocale(String Locale) throws Exception {
		assertTrue(isElementPresent(By.name(localefield), driver));
		new Select(driver.findElement(By.name(localefield)))
		.selectByVisibleText(Locale);
		String strSelectedVal = new Select(driver.findElement(By
				.name(localefield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(Locale));
	}

	public void selectMemberStatus(String MemberStatus) throws Exception {
		assertTrue(isElementPresent(By.name(memberStatus), driver));
		new Select(driver.findElement(By.name(memberStatus)))
		.selectByVisibleText(MemberStatus);
		String strSelectedVal = new Select(driver.findElement(By
				.name(memberStatus))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(MemberStatus));
	}

	public void selectSystemRole(String SystemRole) throws Exception {
		assertTrue(isElementPresent(By.name(systemRole), driver));
		new Select(driver.findElement(By.name(systemRole)))
		.selectByVisibleText(SystemRole);
		String strSelectedVal = new Select(driver.findElement(By
				.name(systemRole))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(SystemRole));
	}

	public void selectJobRole(String JobRole) throws Exception {
		assertTrue(isElementPresent(By.name(jobRole), driver));
		new Select(driver.findElement(By.name(jobRole)))
		.selectByVisibleText(JobRole);
		String strSelectedVal = new Select(driver.findElement(By.name(jobRole)))
		.getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(JobRole));
	}

	public void enterJobTitle(String JobTitle) throws Exception {
		driver.findElement(By.id(jobtitle)).clear();
		driver.findElement(By.id(jobtitle)).sendKeys(JobTitle);
		assertEquals(JobTitle, driver.findElement(By.id(jobtitle))
				.getAttribute("value"));
	}

	public void selectSave() throws Exception {
		driver.findElement(By.name(savebutton)).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	public void selectGender(String genderType) throws Exception {
		driver.findElement(By.xpath(gender));
		driver.findElement(By.xpath(gender)).click();
	}

	public void AddUser(String userName, String emailAddress, String salutation,String firstName,String middleName,
			String lastName, String password, String timeZone, String locale,
			String MemberStatus, String SystemRole, String JobRole,
			String genderType) throws Exception {
		switchToGeneralTab();
		enterusername(userName);
		enterConfirmUsername(userName);
		enterEmail(emailAddress);
		enterConfirmEmail(emailAddress);
		selectSalutation(salutation);
		enterFirstName(firstName);
		enterMiddleName(middleName);
		enterLastName(lastName);
		enterPassword(password);
		enterConfirmPassword(password);
		selectTimeZone(timeZone);
		selectLocale(locale);
		selectGender(genderType);
		switchToStatusTab();
		selectMemberStatus(MemberStatus);
		switchToSettingsTab();
		selectSystemRole(SystemRole);
		selectJobRole(JobRole);
		selectSave();
		switchToAffiliationsTab();
	}
}