package requirement.nmhg;

import org.testng.annotations.Test;
import lib.Configuration;
import pages.nmhg.AdminPage;
import pages.nmhg.MembershipPage;
import pages.nmhg.HomePage;
import pages.nmhg.LoginPage;
import pages.nmhg.UserPage;
import dataobject.nmhg.*;

public class AddEditUser extends Configuration {

	@Test
	public void addUserToCenter() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO, gstrTCID;

		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		LoginData objLoginData = new LoginData();
		UserPageData objUserData = new UserPageData();
	
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL().login(objLoginData.adminUserName,
				objLoginData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.verifyHomePage(objLoginData.homePagetitle)
					.navigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.addUser();

		UserPage objUserPage = new UserPage(driver);
		objUserPage.addNewUser(objUserData.emailId,
				objUserData.salutation, objUserData.firstName,
				objUserData.middleName, objUserData.lastName,
				objUserData.password, objUserData.timeZone,
				objUserData.locale, objUserData.memberStatus,
				objUserData.systemRole, objUserData.jobRole,
				objUserData.jobTitle);

		MembershipPage objMemberPage = new MembershipPage(
				this.driver);
		objMemberPage.mapToCenterMembership(
				objUserData.centerSubtype,
				objUserData.centerSrc);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.logOff();
		objLoginPage.login(objUserData.emailId,objUserData.password)		
					.acceptAgreement()
					.passwordReset(objUserData.newPassword,objUserData.newPassword);
		
		objHomePage.verifyProfile(objUserData.emailId);
	}
}