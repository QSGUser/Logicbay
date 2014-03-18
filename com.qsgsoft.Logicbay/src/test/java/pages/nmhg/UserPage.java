package pages.nmhg;

import org.openqa.selenium.WebDriver;

public class UserPage extends pages.core.UserPage {

	public UserPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public UserPage addNewUser(String emailAddress, String salutation,
			String firstName, String middleName, String lastName,
			String Password, String TimeZone, String Locale,
			String MemberStatus, String SystemRole, String JobRole,
			String JobTitle) throws Exception {
		this.selectGeneralTab();
		enterEmail(emailAddress);
		enterConfirmEmail(emailAddress);
		selectSalutation(salutation);
		enterFirstName(firstName);
		enterMiddleName(middleName);
		enterLastName(lastName);
		enterPassword(Password);
		enterConfirmPassword(Password);
		selectTimeZone(TimeZone);
		selectLocale(Locale);
		selectStatusTab();
		selectMemberStatus(MemberStatus);
		selectSettingsTab();
		selectSystemRole(SystemRole);
		selectJobRole(JobRole);
		enterJobTitle(JobTitle);
		clickSave();
		selectAffiliationsTab();
		return this;
	}
}