package requirement.nmhg;

import org.testng.annotations.Test;
import lib.Configuration;
import pages.nmhg.AdminPage;
import pages.nmhg.AssetsPage;
import pages.nmhg.HomePage;
import pages.nmhg.LoginPage;
import dataobject.nmhg.*;

public class DisplayGroupProperties extends Configuration {
	
	@Test
	public void addQuickLinkToAsset() throws Exception {
		@SuppressWarnings("unused")
		String gstrTO = "Verify that a quicklink can be added by associating to an existing asset",
			   gstrTCID = "132537";
		
		LoginData objLoginData = new LoginData();
		AssetsData objAssetsData=new AssetsData();
		
		LoginPage objLoginPage = new LoginPage(this.driver);
		objLoginPage.openURL();
		objLoginPage.login(objLoginData.adminUserName, objLoginData.adminPassword);

		HomePage objHomePage = new HomePage(this.driver);
		objHomePage.verifyHomePage(objLoginData.homePagetitle)
					.navigateToAdmin();

		AdminPage objAdminPage = new AdminPage(this.driver);
		objAdminPage.addAsset();

		AssetsPage objAssetsPage = new AssetsPage(
				this.driver);
		objAssetsPage.createNewAsset(objAssetsData.quicklinkTitle,
				objAssetsData.contentType, objAssetsData.linkURL);

		objAdminPage.addQuickLink();
		objAssetsPage.mapLinkToAsset(objAssetsData.quicklinkTitle);
		
		objAdminPage.returnToHome();
		objHomePage.verifyHomePage(objLoginData.homePagetitle);
		objHomePage.selectQuickLink(objAssetsData.quicklinkTitle)
					.verifyQuickLink();
	}
}