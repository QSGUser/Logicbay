package com.qsgsoft.Logicbay.pages.daimler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.pages.core.HomePage;

public class DaimlerHomePage extends HomePage {
	private static String CenterTab = "_PCMM_TabText_5";
	private static String Admin = "_PCMM_ID_50_text";
	private static String myprofile = "profile_link";
	private static String email = "email";
	public static WebDriver driver;

	public DaimlerHomePage(WebDriver _driver) {
		super(driver);
		DaimlerHomePage.driver = _driver;
	}

	public void NavigateToAdmin(WebDriver driver) throws Exception {
		selectCampusTab(driver);
		selectAdmin(driver);
	}

	public void selectCampusTab(WebDriver driver) throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));
		action.moveToElement(driver.findElement(By.id(CenterTab))).click()
				.build().perform();
	}

	public void selectAdmin(WebDriver driver) throws Exception {
		Actions action = new Actions(driver);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("mainFrame")));
		driver.switchTo().frame("menuiframe_5");
		action.moveToElement(driver.findElement(By.id(Admin))).click().build()
				.perform();
	}
	
	// Function to select my profile
		public void selectMyProfile(String username) throws Exception {
			driver.switchTo().window("");
			driver.switchTo().frame(driver.findElement(By.name("topFrame")));
			driver.findElement(By.id(myprofile)).click();
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
			String assetMenu = driver.getTitle();
			assertTrue(assetMenu.contains("Edit Profile"));
			driver.findElement(By.id(email));
			String LoginUser=driver.findElement(By.id(email)).getAttribute("Value");
			assertEquals(username,LoginUser);
			System.out.println("Created user is logged in");
			driver.switchTo().window(mainWindowHandle);
		}
}