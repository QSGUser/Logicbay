package com.qsgsoft.Logicbay.requirement.nmhg;

import org.junit.Test;
import com.qsgsoft.Logicbay.pages.core.AdminPage;
import com.qsgsoft.Logicbay.pages.core.AssetsManagementPage;
import com.qsgsoft.Logicbay.pages.core.HomePage;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import com.qsgsoft.Logicbay.pages.nmhg.NmhgHomePage;
import com.qsgsoft.Logicbay.pages.nmhg.NmhgLoginPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

public class Display_GroupPropertiesNmhg extends Configuration{
	String gstrTO, gstrTCID, url, strAdminUserName, strAdminPassword;
	TestData objTestData = new TestData();

	@Test
	public void AddQuickLinkToAsset() throws Exception {
		gstrTO = "Verify that a quicklink can be added by associating to an existing asset";
		gstrTCID = "132537";
		strAdminUserName = objTestData.strNmhgAdminName;
		strAdminPassword = objTestData.strNmhgAdminPassword;
		String strQuicklinkTitle = objTestData.strQuicklinkTitle;
		String strcontentType = objTestData.strcontentType;
		String strLinkUrl = objTestData.strLinkURL;

		// Creating the objects
		LoginPage objLoginPage = new LoginPage(this.driver);
		NmhgLoginPage objNmhgLoginPage = new NmhgLoginPage(driver);
		NmhgHomePage objNmhgHomePage=new NmhgHomePage(driver);
		HomePage objHomePage = new HomePage(driver);
		AdminPage objAdminPage = new AdminPage(driver);
		AssetsManagementPage objAssetsManagementPage = new AssetsManagementPage(
				driver);

		// Calling the functions
		objNmhgLoginPage.openURL(driver);
		objLoginPage.login(strAdminUserName, strAdminPassword);
		objNmhgHomePage.NavigateToAdmin();
		objAdminPage.selectAssetManagement();
		objAssetsManagementPage.createNewAsset(strQuicklinkTitle,
				strcontentType, strLinkUrl);
		objAdminPage.selectGroups();
		objAssetsManagementPage.mapLinkToAsset(strQuicklinkTitle);
		objAdminPage.returnToHome();
		objHomePage.selectQuickLink(strQuicklinkTitle);
		objHomePage.verifyQuickLink();
	}
}