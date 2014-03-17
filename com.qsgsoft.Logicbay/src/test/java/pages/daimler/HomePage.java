package pages.daimler;

import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends pages.core.HomePage {
	private String CenterTab = "//*[contains(text(),'Centers')]",
			Admin = "//*[contains(text(), 'Admin')]",
			myprofile = "profile_link", 
			topFramename = "topFrame",
			mainFramename="mainFrame",
			adminsubframe="menuiframe_5";
	
	public HomePage(WebDriver _driver) {
		super(_driver);
		HomePage.driver = _driver;
	}

	public HomePage NavigateToAdmin() throws Exception {
		selectCampusTab();
		selectAdmin();
		return this;
	}
	public HomePage verifyHomePage(String title)throws Exception{
		waitForPageToLoad();
		String homePagetitle = driver.getTitle();
		assertTrue(homePagetitle.contains(title));
		return this;
	}

	public HomePage selectCampusTab() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(topFramename, "name");
		element = getElement(CenterTab, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public HomePage selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(mainFramename, "name");
		driver.switchTo().frame(adminsubframe);
		element = getElement(Admin, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	// Function to select my profile
	public HomePage selectMyProfile(String username) throws Exception {
		switchToFrame(topFramename, "name");
		String mainWindowHandle = driver.getWindowHandle();
		element = getElement(myprofile, "id");
		element.click();
		waitForPageToLoad();
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		String assetMenu = driver.getTitle();
		assertTrue(assetMenu.contains("Edit Profile"));
		verifyUser(username);
		driver.switchTo().window(mainWindowHandle);
		return this;
	}
}