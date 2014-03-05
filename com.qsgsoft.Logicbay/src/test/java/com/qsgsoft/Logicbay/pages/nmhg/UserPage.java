package com.qsgsoft.Logicbay.pages.nmhg;

import org.openqa.selenium.WebDriver;

public class UserPage extends com.qsgsoft.Logicbay.pages.core.UserPage {	
	public static WebDriver driver;

	public UserPage(WebDriver _driver) {
		super(_driver);
		UserPage.driver = _driver;
	}

	public void AddUser(String emailAddress,String salutation, String firstName,
			String middleName,String lastName, String Password, String TimeZone, String Locale,
			String MemberStatus, String SystemRole, String JobRole,
			String JobTitle) throws Exception {
		this.switchToGeneralTab();
		this.enterEmail(emailAddress);
		this.enterConfirmEmail(emailAddress);
		this.selectSalutation(salutation);
		this.enterFirstName(firstName);
		this.enterMiddleName(middleName);
		this.enterLastName(lastName);
		this.enterPassword(Password);
		this.enterConfirmPassword(Password);
		this.selectTimeZone(TimeZone);
		this.selectLocale(Locale);
		this.switchToStatusTab();
		this.selectMemberStatus(MemberStatus);
		this.switchToSettingsTab();
		this.selectSystemRole(SystemRole);
		this.selectJobRole(JobRole);
		this.enterJobTitle(JobTitle);
		this.selectSave();
		this.switchToAffiliationsTab();
	}
}