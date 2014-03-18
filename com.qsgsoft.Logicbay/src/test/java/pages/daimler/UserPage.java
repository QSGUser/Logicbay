package pages.daimler;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UserPage extends pages.core.UserPage {

	private String usernamefield = "usernameMode",
				   accountfield = "accountUsed";
	
	public UserPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public UserPage addNewUser(String userName, String emailAddress, String firstName,
			String middleName, String lastName, String password,
			String technicalId, String timeZone, String locale,
			String memberStatus, String systemRole, String jobRole,
			String associatedAccount) throws Exception {
		this.selectGeneralTab();
		selectUserName(userName);
		enterEmail(emailAddress);
		enterConfirmEmail(emailAddress);
		enterFirstName(firstName);
		enterMiddleName(middleName);
		enterLastName(lastName);
		enterPassword(password);
		enterConfirmPassword(password);
		enterEmpId(technicalId);
		selectTimeZone(timeZone);
		selectLocale(locale);
		selectStatusTab();
		selectMemberStatus(memberStatus);
		selectSettingsTab();
		selectSystemRole(systemRole);
		selectJobRole(jobRole);
		selectAccount(associatedAccount);
		clickSave();
		selectAffiliationsTab();
		return this;
	}

	public UserPage selectUserName(String UserName) throws Exception {
		assertTrue(isElementPresent(By.id(usernamefield)));
		element=getElement(usernamefield,"id");
		new Select(element)
				.selectByVisibleText(UserName);
		String SelectedVal = new Select(element).getFirstSelectedOption().getText();
		assertTrue(SelectedVal.equals(UserName));
		return this;
	}

	public UserPage selectAccount(String associatedAccount) throws Exception {
		assertTrue(isElementPresent(By.id(accountfield)));
		element=getElement(accountfield,"id");
		new Select(element)
				.selectByVisibleText(associatedAccount);
		String strSelectedVal = new Select(element).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(associatedAccount));
		return this;
	}
}