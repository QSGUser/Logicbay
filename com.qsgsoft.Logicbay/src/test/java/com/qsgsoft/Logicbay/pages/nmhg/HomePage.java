package com.qsgsoft.Logicbay.pages.nmhg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends com.qsgsoft.Logicbay.pages.core.HomePage {
	private String CenterTab = "_PCMM_TabText_7";
	private String Admin = "_PCMM_ID_155_text";
	public static WebDriver driver;

	public HomePage(WebDriver _driver) {
		super(_driver);
		HomePage.driver = _driver;
	}

	public void NavigateToAdmin() throws Exception {
		selectCenterTab();
		selectAdmin();
	}

	public void selectCenterTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("topFrame");
		action.moveToElement(driver.findElement(By.id(CenterTab))).click()
				.build().perform();
	}

	public void selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame("mainFrame");
		driver.switchTo().frame("menuiframe_7");
		action.moveToElement(driver.findElement(By.id(Admin))).click().build()
				.perform();
	}
}