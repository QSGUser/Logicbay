package com.qsgsoft.Logicbay.pages.nmhg;

import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.pages.core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.core.UserPage;

public class NmhgUserPage extends UserPage {
	MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(driver);
	public static WebDriver driver;

	public NmhgUserPage(WebDriver _driver) {
		super(driver);
	}

	public void NmhgUserCreation(String emailAddress, String firstName,
			String lastName, String Password, String TimeZone, String Locale,
			String MemberStatus, String SystemRole, String JobRole,
			String JobTitle) throws Exception {
		switchToGeneralTab();
		enterEmail(emailAddress);
		enterConfirmEmail(emailAddress);
		enterFirstName(firstName);
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

	public void NmhgUserMapping(String strcentersubType, String strcenterSrc)
			throws Exception {
		objMembershipAdminPage.selectcenterMembership(strcentersubType,
				strcenterSrc);
		objMembershipAdminPage.selectSubmitOnMapping();
		objMembershipAdminPage.selectReturnOnMapping();
	}
}