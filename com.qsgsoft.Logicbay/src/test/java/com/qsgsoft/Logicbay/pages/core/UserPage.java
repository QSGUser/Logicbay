package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class UserPage extends WaitForElement {

	private String usernamefield = "username",
			confirmUsernamefield = "confirm_username", emailfield = "email",
			confirmEmailfield = "confirm_email",
			salutationfield = "salutation", firstnamefield = "first_name",
			middlenamefield = "middle_name", lastnamefield = "last_name",
			passwordfield = "new_password",
			confirmpasswordfield = "confirm_new_password",
			employeeIdfield = "employee_id", localefield = "localeFK",
			timezone = "timezone", generalTab = "tab_1", statusTab = "tab_2",
			settingsTab = "tab_3", AffiliationsTab = "tab_6",
			memberStatus = "approvalStatus", systemRole = "role",
			jobRole = "job", jobtitle = "empType", savebutton = "saveGroup",
			gender = "//input[@type='radio']";

	public WebDriver driver;

	public UserPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public UserPage switchToFrame(String FrameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(FrameName)));
		return this;
	}

	public UserPage switchToGeneralTab() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame("main");
		driver.findElement(By.id(generalTab));
		action.moveToElement(driver.findElement(By.id(generalTab))).click()
				.build().perform();
		return this;
	}

	public UserPage switchToStatusTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(statusTab));
		action.moveToElement(driver.findElement(By.id(statusTab))).click()
				.build().perform();
		return this;
	}

	public UserPage switchToSettingsTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(settingsTab));
		action.moveToElement(driver.findElement(By.id(settingsTab))).click()
				.build().perform();
		return this;
	}

	public UserPage switchToAffiliationsTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(AffiliationsTab)).click();
		action.moveToElement(driver.findElement(By.id(AffiliationsTab)))
				.click().build().perform();
		return this;
	}

	public UserPage enterusername(String username) throws Exception {
		driver.findElement(By.id(usernamefield)).clear();
		driver.findElement(By.id(usernamefield)).sendKeys(username);
		assertEquals(username, driver.findElement(By.id(usernamefield))
				.getAttribute("value"));
		return this;
	}

	public UserPage enterConfirmUsername(String confirmUsername) throws Exception {
		driver.findElement(By.id(confirmUsernamefield)).clear();
		driver.findElement(By.id(confirmUsernamefield)).sendKeys(
				confirmUsername);
		assertEquals(
				confirmUsername,
				driver.findElement(By.id(confirmUsernamefield)).getAttribute(
						"value"));
		return this;
	}

	public UserPage enterEmail(String emailAddress) throws Exception {
		driver.findElement(By.id(emailfield)).clear();
		driver.findElement(By.id(emailfield)).sendKeys(emailAddress);
		assertEquals(emailAddress, driver.findElement(By.id(emailfield))
				.getAttribute("value"));
		return this;
	}

	public UserPage enterConfirmEmail(String emailAddress) throws Exception {
		driver.findElement(By.id(confirmEmailfield)).clear();
		driver.findElement(By.id(confirmEmailfield)).sendKeys(emailAddress);
		assertEquals(emailAddress, driver.findElement(By.id(confirmEmailfield))
				.getAttribute("value"));
		return this;
	}

	public UserPage selectSalutation(String salutation) throws Exception {
		assertTrue(isElementPresent(By.name(salutationfield), driver));
		new Select(driver.findElement(By.name(salutationfield)))
				.selectByVisibleText(salutation);
		String strSelectedVal = new Select(driver.findElement(By
				.name(salutationfield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(salutation));
		return this;
	}

	public UserPage enterFirstName(String firstName) throws Exception {
		driver.findElement(By.id(firstnamefield)).clear();
		driver.findElement(By.id(firstnamefield)).sendKeys(firstName);
		assertEquals(firstName, driver.findElement(By.id(firstnamefield))
				.getAttribute("value"));
		return this;
	}

	public UserPage enterMiddleName(String middleName) throws Exception {
		driver.findElement(By.id(middlenamefield)).clear();
		driver.findElement(By.id(middlenamefield)).sendKeys(middleName);
		assertEquals(middleName, driver.findElement(By.id(middlenamefield))
				.getAttribute("value"));
		return this;
	}

	public UserPage enterLastName(String lastName) throws Exception {
		driver.findElement(By.id(lastnamefield)).clear();
		driver.findElement(By.id(lastnamefield)).sendKeys(lastName);
		assertEquals(lastName, driver.findElement(By.id(lastnamefield))
				.getAttribute("value"));
		return this;
	}

	public UserPage enterPassword(String password) throws Exception {
		driver.findElement(By.id(passwordfield)).clear();
		driver.findElement(By.id(passwordfield)).sendKeys(password);
		assertEquals(password, driver.findElement(By.id(passwordfield))
				.getAttribute("value"));
		return this;
	}

	public UserPage enterConfirmPassword(String password) throws Exception {
		driver.findElement(By.id(confirmpasswordfield)).clear();
		driver.findElement(By.id(confirmpasswordfield)).sendKeys(password);
		assertEquals(password, driver.findElement(By.id(confirmpasswordfield))
				.getAttribute("value"));
		return this;
	}

	public UserPage enterTechOrEmpID(String ID) throws Exception {
		driver.findElement(By.id(employeeIdfield)).clear();
		driver.findElement(By.id(employeeIdfield)).sendKeys(ID);
		assertEquals(ID, driver.findElement(By.id(employeeIdfield))
				.getAttribute("value"));
		return this;
	}

	public UserPage selectTimeZone(String TimeZone) throws Exception {
		assertTrue(isElementPresent(By.name(timezone), driver));
		new Select(driver.findElement(By.name(timezone)))
				.selectByVisibleText(TimeZone);
		String strSelectedVal = new Select(
				driver.findElement(By.name(timezone))).getFirstSelectedOption()
				.getText();
		assertTrue(strSelectedVal.equals(TimeZone));
		return this;
	}

	public UserPage selectLocale(String Locale) throws Exception {
		assertTrue(isElementPresent(By.name(localefield), driver));
		new Select(driver.findElement(By.name(localefield)))
				.selectByVisibleText(Locale);
		String strSelectedVal = new Select(driver.findElement(By
				.name(localefield))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(Locale));
		return this;
	}

	public UserPage selectMemberStatus(String MemberStatus) throws Exception {
		assertTrue(isElementPresent(By.name(memberStatus), driver));
		new Select(driver.findElement(By.name(memberStatus)))
				.selectByVisibleText(MemberStatus);
		String strSelectedVal = new Select(driver.findElement(By
				.name(memberStatus))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(MemberStatus));
		return this;
	}

	public UserPage selectSystemRole(String SystemRole) throws Exception {
		assertTrue(isElementPresent(By.name(systemRole), driver));
		new Select(driver.findElement(By.name(systemRole)))
				.selectByVisibleText(SystemRole);
		String strSelectedVal = new Select(driver.findElement(By
				.name(systemRole))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(SystemRole));
		return this;
	}

	public UserPage selectJobRole(String JobRole) throws Exception {
		assertTrue(isElementPresent(By.name(jobRole), driver));
		new Select(driver.findElement(By.name(jobRole)))
				.selectByVisibleText(JobRole);
		String strSelectedVal = new Select(driver.findElement(By.name(jobRole)))
				.getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(JobRole));
		return this;
	}

	public UserPage enterJobTitle(String JobTitle) throws Exception {
		driver.findElement(By.id(jobtitle)).clear();
		driver.findElement(By.id(jobtitle)).sendKeys(JobTitle);
		assertEquals(JobTitle, driver.findElement(By.id(jobtitle))
				.getAttribute("value"));
		return this;
	}

	public UserPage selectSave() throws Exception {
		driver.findElement(By.name(savebutton)).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		return this;
	}

	public UserPage selectGender(String genderType) throws Exception {
		driver.findElement(By.xpath(gender));
		driver.findElement(By.xpath(gender)).click();
		return this;
	}

	public UserPage AddUser(String userName, String emailAddress,
			String salutation, String firstName, String middleName,
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
		return this;
	}
}