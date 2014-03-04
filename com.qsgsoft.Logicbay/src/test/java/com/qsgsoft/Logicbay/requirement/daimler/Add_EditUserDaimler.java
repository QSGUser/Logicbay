package com.qsgsoft.Logicbay.requirement.daimler;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.daimler.DaimlerHomePage;
import com.qsgsoft.Logicbay.pages.daimler.DaimlerLoginPage;
import com.qsgsoft.Logicbay.pages.daimler.DaimlerUserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

public class Add_EditUserDaimler extends Configuration {

	String gstrTO, gstrTCID, url, strAdminUserName, strAdminPassword;
	TestData objTestData = new TestData();

	@Test
	public void AddUserToDaimlerServer() throws Exception {
		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		strAdminUserName = objTestData.strDaimlerLoginName;
		strAdminPassword = objTestData.strDaimlerPassword;
		// Data for creating a user
		String strUserName = objTestData.strDaimlerUserName;
		String strEmailAddress = objTestData.strEmailAddress;
		String strFirstName = objTestData.strFirstName;
		String strMiddleName = objTestData.strMiddleName;
		String strLastName = objTestData.strLastName;
		String strPassword = objTestData.strPassword;
		String strTechnicalId = objTestData.strTecnicalId;
		String strTimeZone = objTestData.strTimezone;
		String strLocale = objTestData.strLocale;
		String strMemberStatus = objTestData.strMemberstatus;
		String strSystemRole = objTestData.strSystemrole;
		String strJobRole = objTestData.strDaimlerJobRole;
		String strAssociatedAccount = objTestData.strDaimlerAccount;
		String strcentersubType = objTestData.strcenterSubtype;
		String strcenterSrc = objTestData.strcenterSrcDaimler;
		String strnewPassword = objTestData.strnewPassword;
		// Creating the objects
		HomePage objHomePage = new HomePage(driver);
		LoginPage objLoginPage = new LoginPage(this.driver);
		DaimlerLoginPage objDaimlerLoginPage = new DaimlerLoginPage(driver);
		DaimlerHomePage objDaimlerHomePage = new DaimlerHomePage(driver);
		DaimlerUserPage objDaimlerUserPage = new DaimlerUserPage(driver);
		AdminPage objAdminPage = new AdminPage(driver);
		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				driver);
		// Calling the functions
		objDaimlerLoginPage.openURL(driver);
		objDaimlerLoginPage.loginToDaimler(strAdminUserName, strAdminPassword);
		objDaimlerHomePage.NavigateToAdmin(driver);
		objAdminPage.SelectUserAdmin();
		objDaimlerUserPage.AddUser(strUserName, strEmailAddress,
				strFirstName, strMiddleName, strLastName, strPassword,
				strTechnicalId, strTimeZone, strLocale, strMemberStatus,
				strSystemRole, strJobRole, strAssociatedAccount);
		objMembershipAdminPage.MapToCenterMembership(strcentersubType,
				strcenterSrc);
		objAdminPage.returnToHome();
		objHomePage.logOff();
		objDaimlerLoginPage.loginAsMember(strEmailAddress, strPassword);
		objDaimlerLoginPage.acceptAgreement();
		objLoginPage.passwordReset(strPassword, strnewPassword);
		objDaimlerHomePage.selectMyProfile(strEmailAddress);
	}
}