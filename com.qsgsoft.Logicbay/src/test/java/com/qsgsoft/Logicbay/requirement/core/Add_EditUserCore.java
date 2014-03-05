package com.qsgsoft.Logicbay.requirement.core;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.core.UserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.*;

public class Add_EditUserCore extends Configuration {
	@Test
	public void AddUserToCoreServer() throws Exception {
		String gstrTO, gstrTCID;
		
		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		
		// Creating objects and calling the functions
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(TestData.adminUserName,TestData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.SelectUserAdmin();

		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.AddUser(TestData.UserName,TestData.EmailAddress,TestData.Salutation,
				TestData.FirstName,TestData.MiddleName,TestData.LastName, TestData.Password,
				TestData.TimeZone, TestData.Locale, TestData.MemberStatus, TestData.SystemRole,
				TestData.JobRole, TestData.Gender);
		
		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				this.driver);
		objMembershipAdminPage.MapToCenterMembership(TestData.CenterSubtype,
				TestData.CenterSrc);

		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(TestData.UserName, TestData.Password);
		objLoginPage.passwordReset(TestData.Password,TestData.NewPassword);
		objHomePage.selectMyProfile(TestData.EmailAddress);
	}
}