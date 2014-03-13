package com.qsgsoft.Logicbay.pages.nmhg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends com.qsgsoft.Logicbay.pages.core.HomePage {
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

	public HomePage selectCenterTab() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(topFrameName, "name");
		element = element(CenterTab, "xpath");
		action.moveToElement(element).click()
				.build().perform();
		return this;
	}

	public HomePage selectAdmin() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(mainFrameName, "id");
		driver.switchTo().frame(subframe);
		element = element(Admin, "xpath");
		action.moveToElement(element).click()
				.build().perform();
		return this;
	}
}