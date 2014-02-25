package com.qsgsoft.Logicbay.pages.NMHG;

import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.pages.Core.UserPage;
import com.qsgsoft.Logicbay.pages.Core.MembershipAdminPage;

public class NmhgUserPage extends UserPage{
	public void NmhgUserCreation(WebDriver driver,String emailAddress,String firstName,String lastName,String Password,String TimeZone,String Locale,String MemberStatus,String SystemRole,String JobRole,String JobTitle) throws Exception{
		MembershipAdminPage objMembershipAdminPage=new MembershipAdminPage();
		switchToGeneralTab(driver);
		enterEmail(driver,emailAddress);
		enterConfirmEmail(driver,emailAddress);
		enterFirstName(driver,firstName);
		enterLastName(driver,lastName);
		enterPassword(driver,Password);
		enterConfirmPassword(driver,Password);
		selectTimeZone(driver,TimeZone);
		selectLocale(driver,Locale);
		switchToStatusTab(driver);
		selectMemberStatus(driver,MemberStatus);
		switchToSettingsTab(driver);
		selectSystemRole(driver,SystemRole);
		selectJobRole(driver,JobRole);
		enterJobTitle(driver,JobTitle);
		selectSave(driver);	
		switchToAffiliationsTab(driver);
		objMembershipAdminPage.selectcenterMembership(driver);
		objMembershipAdminPage.selectSubmitOnMapping(driver);
		objMembershipAdminPage.selectReturnOnMapping(driver);
	}
}