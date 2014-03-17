package requirement.core;

import org.testng.annotations.Test;
import lib.Configuration;
import pages.core.AdminPage;
import pages.core.HomePage;
import pages.core.LoginPage;
import pages.core.MembershipPage;
import pages.core.UserPage;
import dataobject.core.*;

public class AddEditUser extends Configuration {
	@Test
	public void AddUserToCoreServer() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO = "Verify that a user can be added in Performance Center", gstrTCID = "132534";

		LoginData objLoginData = new LoginData();
		UserPageData objUserData = new UserPageData();
		
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL()
					.login(objLoginData.adminUserName,objLoginData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.verifyHomePage(objLoginData.homePagetitle)
				   .NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.AddUser(objUserData.UserName,
				objUserData.EmailAddress,
				objUserData.Salutation, objUserData.FirstName,
				objUserData.MiddleName, objUserData.LastName,
				objUserData.Password, objUserData.TimeZone,
				objUserData.Locale, objUserData.MemberStatus,
				objUserData.SystemRole, objUserData.JobRole,
				objUserData.Gender);

		MembershipPage objMemberPage = new MembershipPage(
				this.driver);
		objMemberPage.MapToCenterMembership(
				objUserData.CenterSubtype,
				objUserData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.logOff();

		objLoginPage.login(objUserData.UserName,objUserData.Password)
					.passwordReset(objUserData.Password, objUserData.NewPassword);

		objHomePage.selectMyProfile(objUserData.EmailAddress);
	}
}