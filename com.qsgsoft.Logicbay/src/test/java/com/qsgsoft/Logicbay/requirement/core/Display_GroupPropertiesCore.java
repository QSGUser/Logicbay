package com.qsgsoft.Logicbay.requirement.core;

import org.junit.Test;

import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.AssetsManagementPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

public class Display_GroupPropertiesCore extends Configuration {

	String gstrTO, gstrTCID, url, strAdminUserName, strAdminPassword;
	TestData objTestData = new TestData();

	@Test
	public void AddQuickLinkToAsset() throws Exception {
		gstrTO = "Verify that a quicklink can be added by associating to an existing asset";
		gstrTCID = "132537";
		url = "http://lbapp01.logicbay.com/pc800/";
		strAdminUserName = objTestData.strCoreLoginName;
		strAdminPassword = objTestData.strCorePassword;
		String strQuicklinkTitle = objTestData.strQucklinkTitle;
		String strcontentType = objTestData.strcontentType;
		String strLinkUrl = objTestData.strLinkURL;
		// Creating the objects
		LoginPage objLoginPage = new LoginPage(driver);
		HomePage objHomePage = new HomePage(driver);
		AdminPage objAdminPage = new AdminPage(driver);
		AssetsManagementPage objAssetsManagementPage = new AssetsManagementPage(
				driver);
		// Calling the functions
		objLoginPage.openURL();
		objLoginPage.login(strAdminUserName, strAdminPassword);
		objHomePage.NavigateToAdmin();
		objAdminPage.selectAssetManagement();
		objAssetsManagementPage.createNewAsset(strQuicklinkTitle,
				strcontentType, strLinkUrl);
		objAdminPage.selectGroups();
		objAssetsManagementPage.mapLinkToAsset();
	}

}
