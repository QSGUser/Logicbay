package com.qsgsoft.Logicbay.requirement.core;

import org.testng.annotations.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.AssetsManagementPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.core.LoginPageData;
import com.qsgsoft.Logicbay.dataobject.core.UserGroupsData;

public class Display_GroupPropertiesCore extends Configuration {
	
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