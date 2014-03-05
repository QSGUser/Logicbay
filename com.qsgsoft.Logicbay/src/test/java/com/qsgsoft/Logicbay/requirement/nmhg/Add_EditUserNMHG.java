package com.qsgsoft.Logicbay.requirement.nmhg;

import com.qsgsoft.Logicbay.pages.nmhg.AdminPage;
import com.qsgsoft.Logicbay.pages.nmhg.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.nmhg.HomePage;
import com.qsgsoft.Logicbay.pages.nmhg.LoginPage;
import com.qsgsoft.Logicbay.pages.nmhg.UserPage;
import org.junit.Test;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.nmhg.*;;

public class Add_EditUserNMHG extends Configuration {
	String gstrTO, gstrTCID, url, adminUserName, adminPassword;
	TestData objData = new TestData();

	@Test
	public void AddUserToNmhgServer() throws Exception {
		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		adminUserName = objData.adminUserName;
		adminPassword = objData.adminPassword;
		// Data for creating a contact
		String EmailAddress = objData.EmailAddress;
		String Salutation = objData.Salutation;
		String FirstName = objData.FirstName;
		String MiddleName = objData.MiddleName;
		String LastName = objData.LastName;
		String Password = objData.Password;
		String Locale = objData.Locale;
		String TimeZone = objData.TimeZone;
		String MemberStatus = objData.MemberStatus;
		String SystemRole = objData.SystemRole;
		String JobRole = objData.JobRole;
		String JobTitle = objData.JobTitle;
		String CentersubType = objData.CenterSubtype;
		String CenterSrc = objData.CenterSrc;
		String NewPassword = objData.NewPassword;

		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(adminUserName, adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();
		
		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();
		
		UserPage objUserPage = new UserPage(driver);
		objUserPage.AddUser(EmailAddress, Salutation, FirstName,
				MiddleName, LastName, Password, TimeZone, Locale, MemberStatus,
				SystemRole, JobRole, JobTitle);
		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				this.driver);
		objMembershipAdminPage.NmhgUserMapping(CentersubType, CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(EmailAddress, Password);
		objLoginPage.acceptAgreement();
		objLoginPage.passwordReset(Password, NewPassword);
		objHomePage.selectMyProfile(EmailAddress);
	}
}