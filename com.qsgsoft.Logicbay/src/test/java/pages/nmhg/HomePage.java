package pages.nmhg;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends pages.core.HomePage {
	private String CenterTab = "//*[contains(text(),'Center')]",
			Admin = "//*[contains(text(), 'Admin')]",
			topFrameName = "topFrame", mainFrameName = "mainFrame",
			subframe="menuiframe_7";

	public static WebDriver driver;

	public HomePage(WebDriver _driver) {
		super(_driver);
		HomePage.driver = _driver;
	}

	public HomePage NavigateToAdmin() throws Exception {
		selectCenterTab();
		selectAdmin();
		return this;
	}

	public HomePage verifyHomePage(String title)throws Exception{
		waitForPageToLoad();
		String homePagetitle = driver.getTitle();
		assertTrue(homePagetitle.contains(title));
		return this;
	}
	public HomePage selectCenterTab() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(topFrameName, "name");
		element = getElement(CenterTab, "xpath");
		action.moveToElement(element).click()
				.build().perform();
		return this;
	}

	public HomePage selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(mainFrameName, "name");
		switchToFrame(subframe,"");
		element = getElement(Admin, "xpath");
		action.moveToElement(element).click()
				.build().perform();
		return this;
	}
}