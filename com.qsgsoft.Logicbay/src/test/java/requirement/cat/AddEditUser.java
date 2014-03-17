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
	public void AddUserToCatServer() throws Exception {
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
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.AddUser(objUserCreationData.UserName,objUserCreationData.EmailAddress,objUserCreationData.Salutation,
				objUserCreationData.FirstName,objUserCreationData.MiddleName,objUserCreationData.LastName, objUserCreationData.Password,
				objUserCreationData.TimeZone, objUserCreationData.Locale, objUserCreationData.MemberStatus, objUserCreationData.SystemRole,
				objUserCreationData.JobRole, objUserCreationData.Gender);
		
		MembershipPage objMembershipAdminPage = new MembershipPage(
				this.driver);
		objMembershipAdminPage.MapToCenterMembership(objUserCreationData.CenterSubtype,
				objUserCreationData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(objUserCreationData.UserName, objUserCreationData.Password)
					.passwordReset(objUserCreationData.Password,objUserCreationData.NewPassword);
		objHomePage.selectMyProfile(objUserCreationData.EmailAddress);
	}
}