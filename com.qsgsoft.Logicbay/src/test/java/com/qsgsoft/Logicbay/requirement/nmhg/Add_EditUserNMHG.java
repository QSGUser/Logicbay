package com.qsgsoft.Logicbay.requirement.nmhg;

import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.nmhg.NmhgHomePage;
import com.qsgsoft.Logicbay.pages.nmhg.NmhgLoginPage;
import com.qsgsoft.Logicbay.pages.nmhg.NmhgUserPage;
import org.junit.Test;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

public class Add_EditUserNMHG extends Configuration {
	String gstrTO, gstrTCID, url, strAdminUserName, strAdminPassword;
	TestData objTestData = new TestData();

	@Test
	public void AddUserToNmhgServer() throws Exception {
		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";

		strAdminUserName = objTestData.strNmhgAdminName;
		strAdminPassword = objTestData.strNmhgAdminPassword;
		// Data for creating a contact
		String strEmailAddress = objTestData.strEmailAddress;
		String strSalutation = objTestData.strSalutation;
		String strFirstName = objTestData.strFirstName;
		String strMiddleName = objTestData.strMiddleName;
		String strLastName = objTestData.strLastName;
		String strPassword = objTestData.strPassword;
		String strLocale = objTestData.strLocale;
		String strTimeZone = objTestData.strTimezone;
		String strMemberStatus = objTestData.strMemberstatus;
		String strSystemRole = objTestData.strSystemrole;
		String strJobRole = objTestData.strNmhgJobrole;
		String strJobTitle = objTestData.strJobtitle;
		String strcentersubType = objTestData.strcenterSubtype;
		String strcenterSrc = objTestData.strcenterSrcNMHG;
		String strnewPassword = objTestData.strnewPassword;
		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		NmhgLoginPage objNmhgLoginPage = new NmhgLoginPage(driver);
		HomePage objHomePage = new HomePage(driver);
		NmhgHomePage objNmhgHomePage = new NmhgHomePage(driver);
		AdminPage objAdminPage = new AdminPage(driver);
		NmhgUserPage objNmhgUserPage = new NmhgUserPage(driver);
		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				driver);
		// Calling the functions
		objNmhgLoginPage.openURL(driver);
		objLoginPage.login(strAdminUserName, strAdminPassword);
		objNmhgHomePage.NavigateToAdmin();
		objAdminPage.SelectUserAdmin();
		objNmhgUserPage.AddUser(strEmailAddress, strSalutation, strFirstName,
				strMiddleName, strLastName, strPassword, strTimeZone,
				strLocale, strMemberStatus, strSystemRole, strJobRole,
				strJobTitle);
		objMembershipAdminPage.NmhgUserMapping(strcentersubType, strcenterSrc);
		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(strEmailAddress, strPassword);
		objLoginPage.acceptAgreement();
		objLoginPage.passwordReset(strPassword, strnewPassword);
		objHomePage.selectMyProfile(strEmailAddress);
	}
}