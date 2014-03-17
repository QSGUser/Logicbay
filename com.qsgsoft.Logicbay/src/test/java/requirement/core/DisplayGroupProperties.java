package requirement.core;

import lib.Configuration;
import org.testng.annotations.Test;
import pages.core.AdminPage;
import pages.core.AssetsManagementPage;
import pages.core.HomePage;
import pages.core.LoginPage;
import dataobject.core.LoginPageData;
import dataobject.core.UserGroupsData;

public class DisplayGroupProperties extends Configuration {
	
	@Test
	public void AddQuickLinkToAsset() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO, gstrTCID;
		gstrTO = "Verify that a quicklink can be added by associating to an existing asset";
		gstrTCID = "132537";
		
		LoginPageData objLoginPageData=new LoginPageData();
		UserGroupsData objUserGroupsData=new UserGroupsData();
		
		// Creating the objects and calling the functions
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL().
		login(objLoginPageData.adminUserName, objLoginPageData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.selectAssetOption();

		AssetsManagementPage objAssetsManagementPage = new AssetsManagementPage(
				this.driver);
		objAssetsManagementPage.createNewAsset(objUserGroupsData.QuicklinkTitle,
				objUserGroupsData.ContentType,objUserGroupsData.LinkURL);

		objAdminPage.selectGroups();
		objAssetsManagementPage.mapLinkToAsset(objUserGroupsData.QuicklinkTitle);
		
		objAdminPage.returnToHome();
		
		objHomePage.selectQuickLink(objUserGroupsData.QuicklinkTitle).
		verifyQuickLink();
	}
}