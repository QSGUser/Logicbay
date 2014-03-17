package requirement.nmhg;

import lib.Configuration;
import org.testng.annotations.Test;
import pages.nmhg.AdminPage;
import pages.nmhg.MembershipAdminPage;
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
		LoginPageData objLoginPageData = new LoginPageData();
		UserCreationData objUserCreationData = new UserCreationData();
		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL().login(objLoginPageData.adminUserName,
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
		objMembershipAdminPage.MapToCenterMembership(
				objUserCreationData.CenterSubtype,
				objUserCreationData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage
				.login(objUserCreationData.EmailAddress,
						objUserCreationData.Password)
				.acceptAgreement()
				.passwordReset(objUserCreationData.NewPassword,
						objUserCreationData.NewPassword);

		objHomePage.selectMyProfile(objUserCreationData.EmailAddress);
	}
}