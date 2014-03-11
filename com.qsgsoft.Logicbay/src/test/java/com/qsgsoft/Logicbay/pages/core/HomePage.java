package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class HomePage extends WaitForElement {
	private String CampusTab = "//*[contains(text(),'Campus')]";
	private String Admin = "//*[contains(text(), 'Admin')]";
	private String logoff = "logout_link";
	private String myprofile = "profile_link";
	private String email = "email";
	public WebDriver driver;

	public HomePage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void switchToFrame(String FrameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name(FrameName)));
	}

	public void NavigateToAdmin() throws Exception {
		selectCampusTab();
		selectAdmin();
	}

	public void selectCampusTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("topFrame");
		action.moveToElement(driver.findElement(By.xpath(CampusTab))).click()
				.build().perform();
	}

	public void selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame("mainFrame");
		driver.switchTo().frame("menuiframe_4");
		action.moveToElement(driver.findElement(By.xpath(Admin))).click().build()
				.perform();
	}

	// Function to logout from application
	public void logOff() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("topFrame");
		action.moveToElement(driver.findElement(By.id(logoff))).click().build()
				.perform();
	}

	// Function to select my profile
	public void selectMyProfile(String username) throws Exception {
		switchToFrame("topFrame");
		String mainWindowHandle = driver.getWindowHandle();
		driver.findElement(By.id(myprofile)).click();
		Thread.sleep(5000);
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
		driver.switchTo().frame(driver.findElement(By.name("profile")));
		driver.findElement(By.id(email));
		String LoginUser = driver.findElement(By.id(email)).getAttribute(
				"value");
		assertEquals(username, LoginUser);
		System.out.println("Created user is logged in");
		driver.switchTo().window(mainWindowHandle);
	}

	public void selectQuickLink(String linkTitle) throws Exception {
		Actions action = new Actions(driver);
		switchToFrame("mainFrame");
		action.moveToElement(driver.findElement(By.linkText(linkTitle)))
				.click().build().perform();
	}

	public void verifyQuickLink() throws Exception {
		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(5000);
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		String quicklinkTitle = driver.getTitle();
		assertTrue(quicklinkTitle.contains("Google"));
		System.out.println("Link is created");
	}
}
