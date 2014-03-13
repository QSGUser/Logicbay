package com.qsgsoft.Logicbay.pages.daimler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends com.qsgsoft.Logicbay.pages.core.LoginPage {
	private String loginbutton = "submitImg",
			password = "passwordText",
			enterpassword = "password",
			loginArrowfield = "//input[@src='/daimler_preprod/content/documents/campus_8/pc_html_images/login_btn.png']",
			agreefield = "agree", okfield = "okbutton",
			mainFrameName = "mainFrame";
	
	public LoginPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public LoginPage openURL() throws Exception {
		driver.get("http://lbapp10.logicbay.com/daimler_preprod/login/login.jsp");
		return this;
	}

	public LoginPage login(String strUsername, String strPassword)
			throws Exception {
		this.enterUsername(strUsername);
		enterPassword(strPassword);
		clickLoginButton();
		return this;
	}

	public LoginPage loginAsMember(String emailAddress, String Password)
			throws Exception {
		switchToFrame(mainFrameName, "id");
		enterUsername(emailAddress);
		enterMemberPassword(Password);
		clickMemberLogin();
		return this;
	}

	public LoginPage clickLoginButton() throws Exception {
		element = element(loginbutton, "name");
		element.click();
		return this;
	}

	public LoginPage enterMemberPassword(String Password) throws Exception {
		Actions action = new Actions(driver);
		element = element(password, "id");
		action.moveToElement(element).build().perform();
		element.click();
		element = element(enterpassword, "id");
		driver.findElement(By.id(enterpassword)).sendKeys(Password);
		return this;
	}

	public LoginPage clickMemberLogin() throws Exception {
		element = element(loginArrowfield, "xpath");
		element.click();
		return this;
	}

	public LoginPage acceptAgreement() throws Exception {
		element(agreefield, "name").click();
		element(okfield, "name").click();
		return this;
	}
}