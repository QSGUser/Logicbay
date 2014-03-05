package com.qsgsoft.Logicbay.pages.daimler;

import org.openqa.selenium.WebDriver;

public class AdminPage extends com.qsgsoft.Logicbay.pages.core.AdminPage{
	public static WebDriver driver;
	
	public AdminPage(WebDriver _driver) {
		super(_driver);
		AdminPage.driver=_driver;
	}
}
