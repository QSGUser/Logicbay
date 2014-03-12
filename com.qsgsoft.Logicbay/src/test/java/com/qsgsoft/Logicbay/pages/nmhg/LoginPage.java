package com.qsgsoft.Logicbay.pages.nmhg;

import org.openqa.selenium.WebDriver;

public class LoginPage extends com.qsgsoft.Logicbay.pages.core.LoginPage {

	public static WebDriver driver;

	public LoginPage(WebDriver _driver) {
		super(_driver);
		LoginPage.driver=_driver;
	}
	public LoginPage openURL() throws Exception {
		driver.get("https://test.materialshandlingcentral.com/nmhgstg/login/login.jsp");
		return this;
	}
}
