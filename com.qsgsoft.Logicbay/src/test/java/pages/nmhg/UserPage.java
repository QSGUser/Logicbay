package pages.nmhg;

import org.openqa.selenium.WebDriver;

public class UserPage extends pages.core.UserPage {
	public static WebDriver driver;

	public UserPage(WebDriver _driver) {
		super(_driver);
		UserPage.driver = _driver;
	}

	public UserPage AddUser(String emailAddress, String salutation,
			String firstName, String middleName, String lastName,
			String Password, String TimeZone, String Locale,
			String MemberStatus, String SystemRole, String JobRole,
			String JobTitle) throws Exception {
		this.switchToGeneralTab();
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
		switchToStatusTab();
		selectMemberStatus(MemberStatus);
		switchToSettingsTab();
		selectSystemRole(SystemRole);
		selectJobRole(JobRole);
		enterJobTitle(JobTitle);
		selectSave();
		switchToAffiliationsTab();
		return this;
	}
}