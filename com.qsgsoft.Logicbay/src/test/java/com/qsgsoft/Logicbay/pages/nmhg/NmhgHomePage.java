package com.qsgsoft.Logicbay.pages.nmhg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.pages.core.HomePage;

public class NmhgHomePage extends HomePage {
	private static String CenterTab = "_PCMM_TabText_5";
	private static String Admin = "_PCMM_ID_36_text";
	public static WebDriver driver;
	
	public NmhgHomePage(WebDriver _driver) {
		super(driver);
	}

	public void NavigateToAdmin() throws Exception {
		selectCenterTab();
		selectAdmin();
	}

	public void selectCenterTab() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));
		action.moveToElement(driver.findElement(By.id(CenterTab))).click()
		.build().perform();
	}

	public void selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("mainFrame")));
		driver.switchTo().frame("menuiframe_5");
		action.moveToElement(driver.findElement(By.id(Admin))).click().build()
		.perform();
	}
}