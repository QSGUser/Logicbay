package requirement.core;

import org.testng.annotations.Test;
import lib.Configuration;
import pages.core.AdminPage;
import pages.core.AssetsPage;
import pages.core.HomePage;
import pages.core.LoginPage;
import dataobject.core.LoginData;
import dataobject.core.AssetsData;

public class DisplayGroupPropertiesTest extends Configuration {

	@Test
	public void testAddQuickLinkToAsset() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO, gstrTCID;
		gstrTO = "Verify that a quicklink can be added by associating to an existing asset";
		gstrTCID = "132537";

		LoginData objLoginData = new LoginData();
		AssetsData objAssetsData = new AssetsData();

		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL()
					.login(objLoginData.adminUserName,objLoginData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.verifyHomePage(objLoginData.homePagetitle)
					.navigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.addAsset();

		AssetsPage objAssetsPage = new AssetsPage(this.driver);
		objAssetsPage.createNewAsset(objAssetsData.quicklinkTitle,objAssetsData.contentType, objAssetsData.linkURL);

		objAdminPage.addQuickLink();
		objAssetsPage.mapLinkToAsset(objAssetsData.quicklinkTitle);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle)
				   .selectQuickLink(objAssetsData.quicklinkTitle);
				
	}
}