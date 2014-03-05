package com.qsgsoft.Logicbay.requirement.nmhg;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.AssetsManagementPage;
import com.qsgsoft.Logicbay.pages.nmhg.HomePage;
import com.qsgsoft.Logicbay.pages.nmhg.LoginPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.dataobject.nmhg.*;

public class Display_GroupPropertiesNmhg extends Configuration {
	String gstrTO, gstrTCID, url, adminUserName, adminPassword;
	TestData objData = new TestData();

	@Test
	public void AddQuickLinkToAsset() throws Exception {
		gstrTO = "Verify that a quicklink can be added by associating to an existing asset";
		gstrTCID = "132537";
		adminUserName = objData.adminUserName;
		adminPassword = objData.adminPassword;
		String QuicklinkTitle = objData.QuicklinkTitle;
		String ContentType = objData.ContentType;
		String LinkUrl = objData.LinkURL;

		// Creating the objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(adminUserName, adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.selectAssetManagement();

		AssetsManagementPage objAssetsManagementPage = new AssetsManagementPage(
				this.driver);
		objAssetsManagementPage.createNewAsset(QuicklinkTitle,
				ContentType, LinkUrl);

		objAdminPage.selectGroups();
		objAssetsManagementPage.mapLinkToAsset(QuicklinkTitle);
		objAdminPage.returnToHome();
		objHomePage.selectQuickLink(QuicklinkTitle);
		objHomePage.verifyQuickLink();
	}
}