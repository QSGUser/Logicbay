package com.qsgsoft.Logicbay.requirement.core;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.core.UserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

public class Add_EditUserCore extends Configuration {

	String gstrTO, gstrTCID, url, strAdminUserName, strAdminPassword;
	TestData objTestData = new TestData();

	@Test
	public void AddUserToCoreServer() throws Exception {
		gstrTO = "Verify that a user can be added in Performance Center";
		gstrTCID = "132534";
		url = "http://lbapp01.logicbay.com/pc800/";
		strAdminUserName = objTestData.strCoreLoginName;
		strAdminPassword = objTestData.strCorePassword;
		// Data for creating a user
		String strUserName = objTestData.strUsername;
		String strEmailAddress = objTestData.strEmailAddress;
		String strSalutation=objTestData.strSalutation;
		String strFirstName = objTestData.strFirstName;
		String strMiddleName=objTestData.strMiddleName;
		String strLastName = objTestData.strLastName;
		String strPassword = objTestData.strPassword;
		String strLocale = objTestData.strLocale;
		String strTimeZone = objTestData.strTimezone;
		String strMemberStatus = objTestData.strMemberstatus;
		String strSystemRole = objTestData.strSystemrole;
		String strJobRole = objTestData.strJobrole;
		String strcentersubType = objTestData.strcenterSubtype;
		String strcenterSrc = objTestData.strcenterSrcCore;
		String genderType = objTestData.strgenderType;
		String strnewPassword = objTestData.strnewPassword;
		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		HomePage objHomePage = new HomePage(driver);
		AdminPage objAdminPage = new AdminPage(driver);
		UserPage objUserPage = new UserPage(driver);
		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				driver);
	
		// Calling the functions
		objLoginPage.openURL();
		objLoginPage.login(strAdminUserName, strAdminPassword);
		objHomePage.NavigateToAdmin();
		objAdminPage.SelectUserAdmin();
		objUserPage.AddUser(strUserName, strEmailAddress,strSalutation,strFirstName,strMiddleName,
				strLastName, strPassword, strTimeZone, strLocale,
				strMemberStatus, strSystemRole, strJobRole, genderType);
		objMembershipAdminPage.MapToCenterMembership(strcentersubType,
				strcenterSrc);
		objAdminPage.returnToHome();
		objHomePage.logOff();
		objLoginPage.login(strUserName, strPassword);
		objLoginPage.passwordReset(strPassword, strnewPassword);
		objHomePage.selectMyProfile(strUserName);
	}
}