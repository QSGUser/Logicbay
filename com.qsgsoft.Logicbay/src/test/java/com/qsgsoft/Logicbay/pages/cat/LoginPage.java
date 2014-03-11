package com.qsgsoft.Logicbay.pages.cat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends com.qsgsoft.Logicbay.pages.core.LoginPage{
	private String loginbutton="//input[@type='submit']";
	public static WebDriver driver;

	public LoginPage(WebDriver _driver) {
		super(_driver);
		LoginPage.driver=_driver;
	}
	public void openURL() throws Exception {
		driver.get("https://dpcstage.logicbay.com/dlms/login/landing.jsp?backdoor=yes");
	}
	
	public void clickLoginButton() throws Exception {
		driver.findElement(By.xpath(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}
	
	public void login(String Username,String Password)throws Exception{
		this.enterUsername(Username);
		enterPassword(Password);
		clickLoginButton();
	}
}
