package com.qsgsoft.Logicbay.requirement.daimler;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.daimler.AdminPage;
import com.qsgsoft.Logicbay.pages.daimler.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.daimler.HomePage;
import com.qsgsoft.Logicbay.pages.daimler.LoginPage;
import com.qsgsoft.Logicbay.pages.daimler.UserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.daimler.*;

public class Add_EditUserDaimler extends Configuration {

	String gstrTO, gstrTCID, url, adminUserName, adminPassword;
	TestData objData = new TestData();

	@Test
	public void AddUserToDaimlerServer() throws Exception {
		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		adminUserName = objData.adminUserName;
		adminPassword = objData.adminPassword;
		// Data for creating a user
		String UserName = objData.UserName;
		String EmailAddress = objData.EmailAddress;
		String FirstName = objData.FirstName;
		String MiddleName = objData.MiddleName;
		String LastName = objData.LastName;
		String Password = objData.Password;
		String TechnicalId = objData.TecnicalId;
		String TimeZone = objData.TimeZone;
		String Locale = objData.Locale;
		String MemberStatus = objData.MemberStatus;
		String SystemRole = objData.SystemRole;
		String JobRole = objData.JobRole;
		String AssociatedAccount = objData.AssociatedAccount;
		String CentersubType = objData.CenterSubtype;
		String CenterSrc = objData.CenterSrc;
		String NewPassword = objData.NewPassword;
		//Creating the objects and calling the functions
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.loginToDaimler(adminUserName, adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.AddUser(UserName, EmailAddress, FirstName,
				MiddleName, LastName, Password, TechnicalId,
				TimeZone, Locale, MemberStatus,SystemRole,
				JobRole, AssociatedAccount);

		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				this.driver);
		objMembershipAdminPage.MapToCenterMembership(CentersubType,
				CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.loginAsMember(EmailAddress, Password);
		objLoginPage.acceptAgreement();
		objLoginPage.passwordReset(Password, NewPassword);
		objHomePage.selectMyProfile(EmailAddress);
	}
}