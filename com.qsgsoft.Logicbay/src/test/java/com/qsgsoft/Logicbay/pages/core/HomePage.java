package com.qsgsoft.Logicbay.pages.core;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class HomePage extends WaitForElement {
	private static String CampusTab = "_PCMM_TabText_4";
	private static String Admin = "_PCMM_ID_53_text";
	private static String logoff = "logout_link";
	private static String myprofile = "profile_link";

	public WebDriver driver;

	public HomePage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void NavigateToAdmin() throws Exception {
		selectCampusTab();
		selectAdmin();
	}

	public void selectCampusTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));
		action.moveToElement(driver.findElement(By.id(CampusTab))).click()
		.build().perform();
	}

	public void selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("mainFrame")));
		driver.switchTo().frame("menuiframe_4");
		action.moveToElement(driver.findElement(By.id(Admin))).click().build()
		.perform();
	}

	// Function to logout from application
	public void logOff() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));
		action.moveToElement(driver.findElement(By.id(logoff))).click().build()
		.perform();
	}

	// Function to select my profile
	public void selectMyProfile() throws Exception {
		String firstWinHandle;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));
		driver.findElement((By.id(myprofile)));
		driver.findElement(By.id(myprofile)).click();
		
		Set handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle(); 
		handles.remove(firstWinHandle);
		String winHandle=(String) handles.iterator().next();
		if (winHandle!=firstWinHandle){
			String secondWinHandle=winHandle; 
			driver.switchTo().window(secondWinHandle);
		}
	}

	
}
