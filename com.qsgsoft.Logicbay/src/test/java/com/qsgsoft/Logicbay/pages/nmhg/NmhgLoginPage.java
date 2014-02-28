package com.qsgsoft.Logicbay.pages.nmhg;

import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.pages.core.LoginPage;

public class NmhgLoginPage extends LoginPage {

	public static WebDriver driver;

	public NmhgLoginPage(WebDriver _driver) {
		super(driver);
	}

	public void openURL(WebDriver driver) throws Exception {
		driver.get("https://test.materialshandlingcentral.com/nmhgstg/login/login.jsp");
	}
}
