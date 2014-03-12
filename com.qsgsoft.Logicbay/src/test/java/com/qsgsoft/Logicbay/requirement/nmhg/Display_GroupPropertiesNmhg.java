package com.qsgsoft.Logicbay.requirement.nmhg;


import org.testng.annotations.Test;

import com.qsgsoft.Logicbay.pages.nmhg.AdminPage;
import com.qsgsoft.Logicbay.pages.nmhg.AssetsManagementPage;
import com.qsgsoft.Logicbay.pages.nmhg.HomePage;
import com.qsgsoft.Logicbay.pages.nmhg.LoginPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.nmhg.*;

public class Display_GroupPropertiesNmhg extends Configuration {
	
	@Test
	public void AddQuickLinkToAsset() throws Exception {
	
		@SuppressWarnings("unused")
		String gstrTO = "Verify that a quicklink can be added by associating to an existing asset",
			   gstrTCID = "132537";
		LoginPageData objLoginPageData=new LoginPageData();
		UserGroupsData objUserGroupsData=new UserGroupsData();
		// Creating the objects
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
		objHomePage.selectQuickLink(objUserGroupsData.QuicklinkTitle);
		objHomePage.verifyQuickLink();
	}
}