package com.qsgsoft.Logicbay.requirement.core;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.ManageOrganizationsPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

public class ManageOrgDB_MemberProfiles extends Configuration {
	String gstrTO, gstrTCID, url, strAdminUserName, strAdminPassword;
	TestData objTestData = new TestData();

	@Test
	public void ManageOrganizationDashborad() throws Exception {
		gstrTO = "Verify that Member Profiles of Organization and Sub-Organization can be edited in Manage Org Dashboard";
		gstrTCID = "132536";
		strAdminUserName = objTestData.strCoreLoginName;
		strAdminPassword = objTestData.strCorePassword;

		/*
		 * // Data for creating a user String strUserName =
		 * objTestData.strUsername; String strEmailAddress =
		 * objTestData.strEmailAddress; String strSalutation =
		 * objTestData.strSalutation; String strFirstName =
		 * objTestData.strFirstName; String strMiddleName =
		 * objTestData.strMiddleName; String strLastName =
		 * objTestData.strLastName; String strPassword =
		 * objTestData.strPassword; String strLocale = objTestData.strLocale;
		 * String strTimeZone = objTestData.strTimezone; String strMemberStatus
		 * = objTestData.strMemberstatus; String strSystemRole =
		 * objTestData.strSystemrole; String strJobRole =
		 * objTestData.strCoreJobRole; String strcentersubType =
		 * objTestData.strcenterSubtype; String strcenterSrc =
		 * objTestData.strcenterSrcCore; String genderType =
		 * objTestData.strgenderType; String strnewPassword =
		 * objTestData.strnewPassword; //Data for creating organization and sub
		 * organization
		 */String strOrgName = objTestData.strorgName;
		String strOrgCode = objTestData.strorgCode;
		String strSuborgName = objTestData.strsuborgName;
		String strSuborgCode = objTestData.strsuborgCode;
		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		HomePage objHomePage = new HomePage(driver);
		AdminPage objAdminPage = new AdminPage(driver);
		ManageOrganizationsPage objManageOrganizationsPage = new ManageOrganizationsPage(
				driver);

		// Calling the functions
		objLoginPage.openURL();
		objLoginPage.login(strAdminUserName, strAdminPassword);
		objHomePage.NavigateToAdmin();
		objAdminPage.selectUserGroupsAdmin();
		objManageOrganizationsPage.createOrg(strOrgName, strOrgCode);
		objManageOrganizationsPage.selectCreatedOrg(strOrgName);
		objManageOrganizationsPage.createSubOrg(strSuborgName, strSuborgCode);
	}
}
