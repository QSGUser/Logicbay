package com.qsgsoft.Logicbay.requirement.core;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.ManageOrganizationsPage;
import com.qsgsoft.Logicbay.pages.core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.core.UserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.core.LoginPageData;
import com.qsgsoft.Logicbay.dataobject.core.UserCreationData;
import com.qsgsoft.Logicbay.dataobject.core.UserGroupsData;

public class ManageOrgDB_MemberProfiles extends Configuration {

	@Test
	public void ManageOrganizationDashborad() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO = "Verify that Member Profiles of Organization and Sub-Organization can be edited in Manage Org Dashboard", gstrTCID = "132536";

		LoginPageData objLoginPageData = new LoginPageData();
		UserCreationData objUserCreationData = new UserCreationData();
		UserGroupsData objUserGroupsData = new UserGroupsData();

		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(objLoginPageData.adminUserName,
				objLoginPageData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.selectUserGroupsAdmin();

		ManageOrganizationsPage objManageOrganizationsPage = new ManageOrganizationsPage(
				this.driver);
		objManageOrganizationsPage.createOrg(objUserGroupsData.newOrg,objUserGroupsData.OrgName,
				objUserGroupsData.OrgCode);
		objManageOrganizationsPage.selectCreatedOrg(objUserGroupsData.OrgName);
		objManageOrganizationsPage.createSubOrg(objUserGroupsData.SuborgName,
				objUserGroupsData.SuborgCode);

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
	}
}