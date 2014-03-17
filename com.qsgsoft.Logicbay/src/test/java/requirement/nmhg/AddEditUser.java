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
	public void AddUserToNmhgServer() throws Exception {
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
					.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(driver);
		objUserPage.AddUser(objUserData.EmailAddress,
				objUserData.Salutation, objUserData.FirstName,
				objUserData.MiddleName, objUserData.LastName,
				objUserData.Password, objUserData.TimeZone,
				objUserData.Locale, objUserData.MemberStatus,
				objUserData.SystemRole, objUserData.JobRole,
				objUserData.JobTitle);

		MembershipPage objMemberPage = new MembershipPage(
				this.driver);
		objMemberPage.MapToCenterMembership(
				objUserData.CenterSubtype,
				objUserData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.logOff();
		objLoginPage.login(objUserData.EmailAddress,objUserData.Password)		
					.acceptAgreement()
					.passwordReset(objUserData.NewPassword,objUserData.NewPassword);
		
		objHomePage.selectMyProfile(objUserData.EmailAddress);
	}
}