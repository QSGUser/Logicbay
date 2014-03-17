package requirement.core;

import org.testng.annotations.Test;
import lib.Configuration;
import pages.core.AdminPage;
import pages.core.AssetsPage;
import pages.core.HomePage;
import pages.core.LoginPage;
import dataobject.core.LoginData;
import dataobject.core.AssetsData;

public class DisplayGroupProperties extends Configuration {

	@Test
	public void AddQuickLinkToAsset() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO, gstrTCID;
		gstrTO = "Verify that a quicklink can be added by associating to an existing asset";
		gstrTCID = "132537";

		LoginData objLoginData = new LoginData();
		AssetsData objAssetsData = new AssetsData();

		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL().login(objLoginData.adminUserName,
				objLoginData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.verifyHomePage(objLoginData.homePagetitle)
				.NavigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.selectAssetOption();

		AssetsPage objAssetsPage = new AssetsPage(this.driver);
		objAssetsPage.createNewAsset(objAssetsData.QuicklinkTitle,
				objAssetsData.ContentType, objAssetsData.LinkURL);

		objAdminPage.selectGroups();
		objAssetsPage.mapLinkToAsset(objAssetsData.QuicklinkTitle);

		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.selectQuickLink(objAssetsData.QuicklinkTitle)
				.verifyQuickLink();
	}
}