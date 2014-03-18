package requirement.core;

import org.testng.annotations.Test;
import lib.Configuration;
import pages.core.AdminPage;
import pages.core.HomePage;
import pages.core.LoginPage;
import pages.core.MembershipPage;
import pages.core.UserPage;
import dataobject.core.*;

public class AddEditUserTest extends Configuration {
	@Test
	public void testAddUserToCenter() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO = "Verify that a user can be added in Performance Center", gstrTCID = "132534";

		LoginData objLoginData = new LoginData();
		UserPageData objUserData = new UserPageData();
		
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL()
					.login(objLoginData.adminUserName,objLoginData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.verifyHomePage(objLoginData.homePagetitle)
				   .navigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.addUser();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.addNewUser(objUserData.userName,
				objUserData.emailId,
				objUserData.salutation, objUserData.firstName,
				objUserData.middleName, objUserData.lastName,
				objUserData.password, objUserData.timeZone,
				objUserData.locale, objUserData.memberStatus,
				objUserData.systemRole, objUserData.jobRole,
				objUserData.gender);

		MembershipPage objMemberPage = new MembershipPage(
				this.driver);
		objMemberPage.mapToCenterMembership(
				objUserData.centerSubtype,
				objUserData.centerSrc);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.logOff();

		objLoginPage.login(objUserData.userName,objUserData.password)
					.passwordReset(objUserData.password, objUserData.newPassword);

		objHomePage.verifyProfile(objUserData.emailId);
	}
}