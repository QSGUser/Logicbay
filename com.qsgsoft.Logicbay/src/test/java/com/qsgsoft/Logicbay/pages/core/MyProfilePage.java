package com.qsgsoft.Logicbay.pages.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.qsgsoft.Logicbay.modules.DashboardFunctions;
import static org.junit.Assert.*;

public class MyProfilePage extends DashboardFunctions {
	private static String email = "email";

	public WebDriver driver;

	public MyProfilePage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void verifyUser(String username) throws Exception {
		driver.switchTo().frame(driver.findElement(By.name("profile")));
		driver.findElement(By.id(email));	
		assertEquals(username, driver.findElement(By.name(email))
				.getAttribute("value"));
	}
}