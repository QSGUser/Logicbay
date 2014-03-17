package requirement.core;

import lib.Configuration;
import org.testng.annotations.Test;
import pages.core.AdminPage;
import pages.core.HomePage;
import pages.core.LoginPage;
import pages.core.MembershipAdminPage;
import pages.core.UserPage;
import dataobject.core.*;

public class AddEditUser extends Configuration {
	@Test
	public void AddUserToCoreServer() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO = "Verify that a user can be added in Performance Center", gstrTCID = "132534";

		LoginPageData objLoginPageData = new LoginPageData();
		UserCreationData objUserCreationData = new UserCreationData();
		// Creating objects and calling the functions
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL().login(objLoginPageData.adminUserName,
				objLoginPageData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.AddUser(objUserCreationData.UserName,
				objUserCreationData.EmailAddress,
				objUserCreationData.Salutation, objUserCreationData.FirstName,
				objUserCreationData.MiddleName, objUserCreationData.LastName,
				objUserCreationData.Password, objUserCreationData.TimeZone,
				objUserCreationData.Locale, objUserCreationData.MemberStatus,
				objUserCreationData.SystemRole, objUserCreationData.JobRole,
				objUserCreationData.Gender);

		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				this.driver);
		objMembershipAdminPage.MapToCenterMembership(
				objUserCreationData.CenterSubtype,
				objUserCreationData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();

		objLoginPage.login(objUserCreationData.UserName,
				objUserCreationData.Password).passwordReset(
				objUserCreationData.Password, objUserCreationData.NewPassword);

		objHomePage.selectMyProfile(objUserCreationData.EmailAddress);
	}
}