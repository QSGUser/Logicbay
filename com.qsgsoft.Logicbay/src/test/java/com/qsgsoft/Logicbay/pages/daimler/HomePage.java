package com.qsgsoft.Logicbay.pages.daimler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends com.qsgsoft.Logicbay.pages.core.HomePage {
	private String CenterTab = "_PCMM_TabText_5";
	private String Admin="//*[contains(text(), 'Admin')]";
	private String myprofile = "profile_link";
	private String email = "email";
	public static WebDriver driver;

	public HomePage(WebDriver _driver) {
		super(_driver);
		HomePage.driver = _driver;
	}

	public void NavigateToAdmin() throws Exception {
		selectCampusTab();
		selectAdmin();
	}

	public void selectCampusTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("topFrame");
		action.moveToElement(driver.findElement(By.id(CenterTab))).click()
				.build().perform();
	}

	public void selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame("mainFrame");
		driver.switchTo().frame("menuiframe_5");
		action.moveToElement(driver.findElement(By.xpath(Admin))).click().build().perform();	
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
		driver.findElement(By.id(email));
		String LoginUser = driver.findElement(By.id(email)).getAttribute(
				"value");
		assertEquals(username, LoginUser);
		System.out.println("Created user is logged in");
		driver.switchTo().window(mainWindowHandle);
	}
}