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
	public void AddUserToDaimlerServer() throws Exception {
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
		objUserPage.AddUser(objUserData.UserName, objUserData.EmailAddress,
				objUserData.FirstName, objUserData.MiddleName,
				objUserData.LastName, objUserData.Password,
				objUserData.TecnicalId, objUserData.TimeZone,
				objUserData.Locale, objUserData.MemberStatus,
				objUserData.SystemRole, objUserData.JobRole,
				objUserData.AssociatedAccount);

		MembershipPage objMemberPage = new MembershipPage(this.driver);
		objMemberPage.MapToCenterMembership(objUserData.CenterSubtype,
				objUserData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.logOff();

		objLoginPage.loginAsMember(objUserData.EmailAddress, objUserData.Password)
					.acceptAgreement()
					.passwordReset(objUserData.Password, objUserData.NewPassword);

		objHomePage.selectMyProfile(objUserData.EmailAddress);
	}
}