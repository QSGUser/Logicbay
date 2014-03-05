package com.qsgsoft.Logicbay.requirement.core;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.core.ManageOrganizationsPage;
import com.qsgsoft.Logicbay.pages.core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.core.UserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.*;

public class ManageOrgDB_MemberProfiles extends Configuration {
	String gstrTO, gstrTCID, url, AdminUserName, AdminPassword;
	TestData objData = new TestData();

	@Test
	public void ManageOrganizationDashborad() throws Exception {
		gstrTO = "Verify that Member Profiles of Organization and Sub-Organization can be edited in Manage Org Dashboard";
		gstrTCID = "132536";
		AdminUserName = objData.adminUserName;
		AdminPassword = objData.adminPassword;
		
		String UserName = objData.UserName;
		String EmailAddress = objData.EmailAddress;
		String Salutation = objData.Salutation;
		String FirstName = objData.FirstName;
		String MiddleName = objData.MiddleName;
		String LastName = objData.LastName;
		String Password = objData.Password;
		String Locale = objData.Locale;
		String TimeZone = objData.TimeZone;
		String GenderType = objData.Gender;
		String MemberStatus = objData.MemberStatus;
		String SystemRole = objData.SystemRole;
		String JobRole = objData.JobRole;
		String CentersubType = objData.CenterSubtype;
		String CenterSrc = objData.CenterSrc;
		String OrgName = objData.OrgName;
		String OrgCode = objData.OrgCode;
		String SuborgName = objData.SuborgName;
		String SuborgCode = objData.SuborgCode;
		// Creating objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(AdminUserName, AdminPassword);
		
		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();
		
		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.selectUserGroupsAdmin();
		
		ManageOrganizationsPage objManageOrganizationsPage = new ManageOrganizationsPage(
				this.driver);		
		objManageOrganizationsPage.createOrg(OrgName,OrgCode);
		objManageOrganizationsPage.selectCreatedOrg(OrgName);
		objManageOrganizationsPage.createSubOrg(SuborgName,SuborgCode);
	
		objAdminPage.SelectUserAdmin();
		UserPage objUserPage = new UserPage(this.driver);
		objUserPage.AddUser(UserName, EmailAddress, Salutation,
				FirstName,MiddleName,LastName, Password,
				TimeZone, Locale, MemberStatus, SystemRole,
				JobRole, GenderType);
		
		MembershipAdminPage objMembershipAdminPage = new MembershipAdminPage(
				this.driver);
		objMembershipAdminPage.MapToCenterMembership(CentersubType,
				CenterSrc);			
	}
}
