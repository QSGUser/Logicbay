package com.qsgsoft.Logicbay.requirement.nmhg;

import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.MyProfilePage;
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
		url = "http://test.materialshandlingcentral.com/nmhgstg";
		strAdminUserName = objTestData.strNmhgAdminName;
		strAdminPassword = objTestData.strNmhgAdminPassword;
		// Data for creating a contact
		String strEmailAddress = objTestData.strEmailAddress;
		String strFirstName = objTestData.strFirstName;
		String strLastName = objTestData.strLastName;
		String strPassword = objTestData.strPassword;
		String strLocale = objTestData.strLocale;
		String strTimeZone = objTestData.strTimezone;
		String strMemberStatus = objTestData.strMemberstatus;
		String strSystemRole = objTestData.strSystemrole;
		String strJobRole = objTestData.strJobrole;
		String strJobTitle = objTestData.strJobtitle;
		String strcentersubType = objTestData.strcenterSubtype;
		String strcenterSrc = objTestData.strcenterSrcNMHG;
		String strnewPassword = objTestData.strnewPassword;
		// Creating objects
		NmhgLoginPage objNmhgLoginPage = new NmhgLoginPage(driver);
		LoginPage objLoginPage = new LoginPage(driver);
		HomePage objHomePage = new HomePage(driver);
		NmhgHomePage objNmhgHomePage = new NmhgHomePage(driver);
		AdminPage objAdminPage = new AdminPage(driver);
		NmhgUserPage objNmhgUserPage = new NmhgUserPage(driver);
		MyProfilePage objMyProfilePage = new MyProfilePage(driver);
		// Calling the functions
		objNmhgLoginPage.openURL(driver);
		objLoginPage.login(strAdminUserName, strAdminPassword);
		objNmhgHomePage.NavigateToAdmin();
		objAdminPage.SelectUserAdmin();
		objNmhgUserPage.NmhgUserCreation(strEmailAddress, strFirstName,
				strLastName, strPassword, strTimeZone, strLocale,
				strMemberStatus, strSystemRole, strJobRole, strJobTitle);
		objNmhgUserPage.NmhgUserMapping(strcentersubType, strcenterSrc);
		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(strEmailAddress, strPassword);
		objLoginPage.acceptAgreement();
		objLoginPage.passwordReset(strPassword, strnewPassword);
		objHomePage.selectMyProfile();
		objMyProfilePage.verifyUser(strEmailAddress);
	}
}