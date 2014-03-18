package requirement.daimler;

import org.testng.annotations.Test;
import lib.Configuration;
import pages.daimler.AdminPage;
import pages.daimler.MembershipPage;
import pages.daimler.HomePage;
import pages.daimler.LoginPage;
import pages.daimler.UserPage;
import dataobject.daimler.*;

public class AddEditUser extends Configuration {

	@Test
	public void addUserToCenter() throws Exception {
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
		objUserPage.addNewUser(objUserData.userName, objUserData.emailId,
				objUserData.firstName, objUserData.middleName,
				objUserData.lastName, objUserData.password,
				objUserData.tecnicalId, objUserData.timeZone,
				objUserData.locale, objUserData.memberStatus,
				objUserData.systemRole, objUserData.jobRole,
				objUserData.associatedAccount);

		MembershipPage objMemberPage = new MembershipPage(this.driver);
		objMemberPage.mapToCenterMembership(objUserData.centerSubtype,
				objUserData.centerSrc);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.logOff();

		objLoginPage.loginAsMember(objUserData.emailId, objUserData.password)
					.acceptAgreement()
					.passwordReset(objUserData.password, objUserData.newPassword);

		objHomePage.verifyProfile(objUserData.emailId);
	}
}