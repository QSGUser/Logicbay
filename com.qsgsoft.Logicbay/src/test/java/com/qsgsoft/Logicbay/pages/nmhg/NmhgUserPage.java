package com.qsgsoft.Logicbay.pages.nmhg;

import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.pages.core.UserPage;

public class NmhgUserPage extends UserPage {	
	public static WebDriver driver;

	public NmhgUserPage(WebDriver _driver) {
		super(_driver);
		NmhgUserPage.driver = _driver;
	}

	public void AddUser(String emailAddress,String salutation, String firstName,
			String middleName,String lastName, String Password, String TimeZone, String Locale,
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
	}
}