package com.qsgsoft.Logicbay.requirement.daimler;


import lib.Configuration;

import org.testng.annotations.Test;


import com.qsgsoft.Logicbay.pages.daimler.AdminPage;
import com.qsgsoft.Logicbay.pages.daimler.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.daimler.HomePage;
import com.qsgsoft.Logicbay.pages.daimler.LoginPage;
import com.qsgsoft.Logicbay.pages.daimler.UserPage;
import com.qsgsoft.Logicbay.dataobject.daimler.*;

public class AddEditUserDaimler extends Configuration {

	@Test
	public void AddUserToDaimlerServer() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO = "Verify that a user can be added in Performance Center",
		gstrTCID = "132534";
	
		LoginPageData objLoginPageData=new LoginPageData();
		UserCreationData objUserCreationData=new UserCreationData();
		//Creating the objects and calling the functions
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL().
		login(objLoginPageData.adminUserName, objLoginPageData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.AddUser(objUserCreationData.UserName, objUserCreationData.EmailAddress, objUserCreationData.FirstName,
				objUserCreationData.MiddleName, objUserCreationData.LastName, objUserCreationData.Password, objUserCreationData.TecnicalId,
				objUserCreationData.TimeZone, objUserCreationData.Locale, objUserCreationData.MemberStatus,objUserCreationData.SystemRole,
				objUserCreationData.JobRole, objUserCreationData.AssociatedAccount);

		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				this.driver);
		objMembershipAdminPage.MapToCenterMembership(objUserCreationData.CenterSubtype,
				objUserCreationData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		
		objLoginPage.loginAsMember(objUserCreationData.EmailAddress, objUserCreationData.Password)
					.acceptAgreement()
					.passwordReset(objUserCreationData.Password, objUserCreationData.NewPassword);
		
		objHomePage.selectMyProfile(objUserCreationData.EmailAddress);
	}
}