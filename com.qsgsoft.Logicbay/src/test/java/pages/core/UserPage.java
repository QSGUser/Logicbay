package pages.core;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import lib.WebElements;

public class UserPage extends WebElements {
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
			       gender = "//input[@type='radio']", mainFramename = "main";

	public WebDriver driver;
	public WebElement element;

	public UserPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public UserPage selectGeneralTab() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(mainFramename, "id");
		element = getElement(generalTab, "id");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public UserPage selectStatusTab() throws Exception {
		Actions action = new Actions(driver);
		element = getElement(statusTab, "id");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public UserPage selectSettingsTab() throws Exception {
		Actions action = new Actions(driver);
		element = getElement(settingsTab, "id");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public UserPage selectAffiliationsTab() throws Exception {
		Actions action = new Actions(driver);
		element = getElement(AffiliationsTab, "id");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public UserPage enterUserName(String username) throws Exception {
		element = getElement(usernamefield, "id");
		element.clear();
		element.sendKeys(username);
		assertEquals(username, element.getAttribute("value"));
		return this;
	}

	public UserPage enterConfirmUsername(String confirmUsername)
			throws Exception {
		element = getElement(confirmUsernamefield, "id");
		element.clear();
		element.sendKeys(confirmUsername);
		assertEquals(confirmUsername, element.getAttribute("value"));
		return this;
	}

	public UserPage enterEmail(String emailAddress) throws Exception {
		element = getElement(emailfield, "id");
		element.clear();
		element.sendKeys(emailAddress);
		assertEquals(emailAddress, element.getAttribute("value"));
		return this;
	}

	public UserPage enterConfirmEmail(String emailAddress) throws Exception {
		element = getElement(confirmEmailfield, "id");
		element.clear();
		element.sendKeys(emailAddress);
		assertEquals(emailAddress, element.getAttribute("value"));
		return this;
	}

	public UserPage selectSalutation(String salutation) throws Exception {
		assertTrue(isElementPresent(By.name(salutationfield)));
		element = getElement(salutationfield, "name");
		new Select(element).selectByVisibleText(salutation);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(salutation));
		return this;
	}

	public UserPage enterFirstName(String firstName) throws Exception {
		element = getElement(firstnamefield, "id");
		element.clear();
		element.sendKeys(firstName);
		assertEquals(firstName, element.getAttribute("value"));
		return this;
	}

	public UserPage enterMiddleName(String middleName) throws Exception {
		element = getElement(middlenamefield, "id");
		element.clear();
		element.sendKeys(middleName);
		assertEquals(middleName, element.getAttribute("value"));
		return this;
	}

	public UserPage enterLastName(String lastName) throws Exception {
		element = getElement(lastnamefield, "id");
		element.clear();
		element.sendKeys(lastName);
		assertEquals(lastName, element.getAttribute("value"));
		return this;
	}

	public UserPage enterPassword(String password) throws Exception {
		element = getElement(passwordfield, "id");
		element.clear();
		element.sendKeys(password);
		assertEquals(password, element.getAttribute("value"));
		return this;
	}

	public UserPage enterConfirmPassword(String password) throws Exception {
		element = getElement(confirmpasswordfield, "id");
		element.clear();
		element.sendKeys(password);
		assertEquals(password, element.getAttribute("value"));
		return this;
	}

	public UserPage enterEmpId(String ID) throws Exception {
		element = getElement(employeeIdfield, "id");
		element.clear();
		element.sendKeys(ID);
		assertEquals(ID, element.getAttribute("value"));
		return this;
	}

	public UserPage selectTimeZone(String TimeZone) throws Exception {
		assertTrue(isElementPresent(By.name(timezone)));
		element = getElement(timezone, "name");
		new Select(element).selectByVisibleText(TimeZone);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(TimeZone));
		return this;
	}

	public UserPage selectLocale(String Locale) throws Exception {
		assertTrue(isElementPresent(By.name(localefield)));
		element = getElement(localefield, "name");
		new Select(element).selectByVisibleText(Locale);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(Locale));
		return this;
	}

	public UserPage selectMemberStatus(String MemberStatus) throws Exception {
		assertTrue(isElementPresent(By.name(memberStatus)));
		element = getElement(memberStatus, "name");
		new Select(element).selectByVisibleText(MemberStatus);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(MemberStatus));
		return this;
	}

	public UserPage selectSystemRole(String SystemRole) throws Exception {
		assertTrue(isElementPresent(By.name(systemRole)));
		element = getElement(systemRole, "name");
		new Select(element).selectByVisibleText(SystemRole);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(SystemRole));
		return this;
	}

	public UserPage selectJobRole(String JobRole) throws Exception {
		assertTrue(isElementPresent(By.name(jobRole)));
		element = getElement(jobRole, "name");
		new Select(element)
				.selectByVisibleText(JobRole);
		String SelectedVal = new Select(element)
				.getFirstSelectedOption().getText();
		assertTrue(SelectedVal.equals(JobRole));
		return this;
	}

	public UserPage enterJobTitle(String JobTitle) throws Exception {
		element = getElement(jobtitle, "id");
		element.clear();
		element.sendKeys(JobTitle);
		assertEquals(JobTitle, element
				.getAttribute("value"));
		return this;
	}

	public UserPage clickSave() throws Exception {
		element = getElement(savebutton, "name");
		element.click();
		handleAlert();
		handleAlert();
		return this;
	}

	public UserPage selectGender(String genderType) throws Exception {
		element = getElement(gender, "xpath");
		element.click();
		return this;
	}

	public UserPage addNewUser(String userName, String emailAddress,
			String salutation, String firstName, String middleName,
			String lastName, String password, String timeZone, String locale,
			String MemberStatus, String SystemRole, String JobRole,
			String genderType) throws Exception {
		selectGeneralTab();
		enterUserName(userName);
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
		selectStatusTab();
		selectMemberStatus(MemberStatus);
		selectSettingsTab();
		selectSystemRole(SystemRole);
		selectJobRole(JobRole);
		clickSave();
		selectAffiliationsTab();
		return this;
	}
}