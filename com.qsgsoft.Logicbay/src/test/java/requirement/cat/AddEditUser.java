package requirement.cat;

import org.testng.annotations.Test;
import lib.Configuration;

import dataobject.cat.LoginPageData;
import dataobject.core.UserPageData;
import pages.core.AdminPage;
import pages.core.HomePage;
import pages.cat.LoginPage;
import pages.core.MembershipPage;
import pages.core.UserPage;

public class AddEditUser extends Configuration {
	@Test
	public void addUserToCenter() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO, gstrTCID;
		
		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		
		LoginPageData objLoginPageData=new LoginPageData();
		UserPageData objUserCreationData=new UserPageData();
		// Creating objects and calling the functions
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL()
					.login(objLoginPageData.adminUserName,objLoginPageData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.navigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.addUser();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.addNewUser(objUserCreationData.userName,objUserCreationData.emailId,objUserCreationData.salutation,
				objUserCreationData.firstName,objUserCreationData.middleName,objUserCreationData.lastName, objUserCreationData.password,
				objUserCreationData.timeZone, objUserCreationData.locale, objUserCreationData.memberStatus, objUserCreationData.systemRole,
				objUserCreationData.jobRole, objUserCreationData.gender);
		
		MembershipPage objMembershipAdminPage = new MembershipPage(
				this.driver);
		objMembershipAdminPage.mapToCenterMembership(objUserCreationData.centerSubtype,
				objUserCreationData.centerSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(objUserCreationData.userName, objUserCreationData.password)
					.passwordReset(objUserCreationData.password,objUserCreationData.newPassword);
		objHomePage.verifyProfile(objUserCreationData.emailId);
	}
}