package pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lib.WebElements;

public class HomePage extends WebElements {
	private String CampusTab = "//*[contains(text(),'Campus')]",
				   admin = "//*[contains(text(), 'Admin')]", logoff = "logout_link",
			       myprofile = "profile_link", email = "email",
			       topFramename = "topFrame", mainFramename = "mainFrame",
			       adminsubframe = "menuiframe_4", 
			       profileFramename = "profile",
			       pageTitle = "Google";
	public WebElement element;
	public WebDriver driver;

	public HomePage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public HomePage navigateToAdmin() throws Exception {
		clickCampusTab();
		selectAdmin();
		return this;
	}
	
	public HomePage verifyHomePage(String title)throws Exception{
		String homePagetitle = driver.getTitle();
		assertTrue(homePagetitle.contains(title));
		return this;
	}
	
	// Function to select campus tab on home page
	public HomePage clickCampusTab() throws Exception {
		switchToFrame(topFramename, "name");
		element = getElement(CampusTab, "xpath");
		element.isDisplayed();
		element.click();
		return this;
	}

	// Function to select 'admin' option in campus tab
	public HomePage selectAdmin() throws Exception {
		switchToFrame(mainFramename, "name");
		switchToFrame(adminsubframe, "");
		element = getElement(admin, "xpath");
		element.click();
		return this;
	}

	// Function to logout from application
	public HomePage logOff() throws Exception {
		switchToFrame(topFramename, "name");
		element = getElement(logoff, "id");
		element.isDisplayed();
		element.click();
		return this;
	}

	// Function to select my profile
	public HomePage verifyProfile(String username) throws Exception {
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
		element=getElement(profileFramename, "name");
		driver.switchTo().frame(profileFramename);
		verifyUser(username);
		driver.switchTo().window(mainWindowHandle);
		return this;
	}
	
	public HomePage verifyUser(String username)throws Exception{
		element=getElement(email, "id");
		String LoginUser = element.getAttribute(
				"value");
		assertEquals(username, LoginUser);
		System.out.println("Created user is logged in");
		return this;
	}

	// Function to click new quick link on home homepage
	public HomePage selectQuickLink(String linkTitle) throws Exception {
		switchToFrame(mainFramename, "name");
		element = getElement(linkTitle, "linktext");
		String mainWindowHandle = driver.getWindowHandle();
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
		verifyQuickLink();
		driver.switchTo().window(mainWindowHandle);
		return this;
	}

	public HomePage verifyQuickLink() throws Exception {
		String quicklinkTitle = driver.getTitle();
		assertTrue(quicklinkTitle.contains(pageTitle));
		System.out.println("Link is created");
		return this;
	}
}