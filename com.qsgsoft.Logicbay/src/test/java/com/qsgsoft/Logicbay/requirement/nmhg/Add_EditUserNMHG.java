package com.qsgsoft.Logicbay.requirement.nmhg;

import com.qsgsoft.Logicbay.pages.nmhg.AdminPage;
import com.qsgsoft.Logicbay.pages.nmhg.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.nmhg.HomePage;
import com.qsgsoft.Logicbay.pages.nmhg.LoginPage;
import com.qsgsoft.Logicbay.pages.nmhg.UserPage;
import org.junit.Test;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.nmhg.*;

public class Add_EditUserNMHG extends Configuration {

	@Test
	public void AddUserToNmhgServer() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO, gstrTCID;

		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		LoginPageData objLoginPageData=new LoginPageData();
		UserCreationData objUserCreationData=new UserCreationData();
		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(objLoginPageData.adminUserName,
				objLoginPageData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(driver);
		objUserPage.AddUser(objUserCreationData.EmailAddress,
				objUserCreationData.Salutation, objUserCreationData.FirstName,
				objUserCreationData.MiddleName, objUserCreationData.LastName,
				objUserCreationData.Password, objUserCreationData.TimeZone,
				objUserCreationData.Locale, objUserCreationData.MemberStatus,
				objUserCreationData.SystemRole, objUserCreationData.JobRole,
				objUserCreationData.JobTitle);
		
		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				this.driver);
		objMembershipAdminPage.NmhgUserMapping(objUserCreationData.CenterSubtype,
				objUserCreationData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(objUserCreationData.EmailAddress,
				objUserCreationData.Password);
		objLoginPage.acceptAgreement();
		objLoginPage.passwordReset(objUserCreationData.Password,
				objUserCreationData.NewPassword);
		objHomePage.selectMyProfile(objUserCreationData.EmailAddress);
	}
}