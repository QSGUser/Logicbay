package com.qsgsoft.Logicbay.pages.daimler;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends com.qsgsoft.Logicbay.pages.core.LoginPage {
	private String loginbutton = "submitImg",
			password = "passwordText",
			enterpassword="password",
			loginArrowfield = "//input[@src='/daimler_preprod/content/documents/campus_8/pc_html_images/login_btn.png']",
			agreefield = "agree", okfield = "okbutton";
	public static WebDriver driver;

	public LoginPage(WebDriver _driver) {
		super(_driver);
		LoginPage.driver = _driver;
	}

	public LoginPage openURL() throws Exception {
		driver.get("http://lbapp10.logicbay.com/daimler_preprod/login/login.jsp");
		return this;
	}

	public LoginPage login(String strUsername, String strPassword) throws Exception {
		this.enterUsername(strUsername);
		enterPassword(strPassword);
		clickLoginButton();
		return this;
	}

	public void loginAsMember(String emailAddress, String Password)
			throws Exception {
		switchToWindow("mainFrame");
		enterUsername(emailAddress);
		enterMemberPassword(Password);
		clickMemberLogin();
	}

	public void clickLoginButton() throws Exception {
		driver.findElement(By.name(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}

	public void enterMemberPassword(String Password) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id(password))).build()
				.perform();
		driver.findElement(By.id(password)).click();
		driver.findElement(By.id(enterpassword)).sendKeys(Password);
	}

	public void switchToWindow(String frameName) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(frameName)));
	}

	public void clickMemberLogin() throws Exception {
		driver.findElement(By.xpath(loginArrowfield)).click();
	}

	public void acceptAgreement() throws Exception {
		driver.findElement(By.name(agreefield)).click();
		driver.findElement(By.name(okfield)).click();
	}
}