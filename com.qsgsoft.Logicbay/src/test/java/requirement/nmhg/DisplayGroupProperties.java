package requirement.nmhg;

import lib.Configuration;
import org.testng.annotations.Test;
import pages.nmhg.AdminPage;
import pages.nmhg.AssetsManagementPage;
import pages.nmhg.HomePage;
import pages.nmhg.LoginPage;
import dataobject.nmhg.*;

public class DisplayGroupProperties extends Configuration {
	
	@Test
	public void AddQuickLinkToAsset() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO = "Verify that a quicklink can be added by associating to an existing asset",
			   gstrTCID = "132537";
		
		LoginPageData objLoginPageData=new LoginPageData();
		UserGroupsData objUserGroupsData=new UserGroupsData();
		// Creating the objects and calling the functions
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(objLoginPageData.adminUserName, objLoginPageData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.selectAssetOption();

		AssetsManagementPage objAssetsManagementPage = new AssetsManagementPage(
				this.driver);
		objAssetsManagementPage.createNewAsset(objUserGroupsData.QuicklinkTitle,
				objUserGroupsData.ContentType, objUserGroupsData.LinkURL);

		objAdminPage.selectGroups();
		objAssetsManagementPage.mapLinkToAsset(objUserGroupsData.QuicklinkTitle);
		
		objAdminPage.returnToHome();
		objHomePage.selectQuickLink(objUserGroupsData.QuicklinkTitle)
					.verifyQuickLink();
	}
}