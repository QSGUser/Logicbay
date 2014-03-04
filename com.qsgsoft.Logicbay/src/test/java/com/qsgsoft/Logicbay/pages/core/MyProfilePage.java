package com.qsgsoft.Logicbay.pages.core;

import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.modules.DashboardFunctions;

public class MyProfilePage extends DashboardFunctions {

	public WebDriver driver;

	public MyProfilePage(WebDriver _driver) {
		this.driver = _driver;

	}

	public void verifyUser(String username) throws Exception {

	}
}