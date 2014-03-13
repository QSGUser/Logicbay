package com.qsgsoft.Logicbay.pages.core;

import lib.URLInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qsgsoft.Logicbay.WebElement.WebElements;
import static org.junit.Assert.*;

public class LoginPage extends WebElements implements URLInterface {
	private String username = "username", password = "password",
			loginbutton = "cmdLogin",
			accept = "//input[@name='okbutton']",
			newpassword = "new_password",
			confirmnewpassword = "confirm_new_password",
			submitbutton = "iSubmit";
	public WebDriver driver;
	public WebElement element;

	public LoginPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public LoginPage openURL() throws Exception {
		this.driver.get("http://lbapp01.logicbay.com/pc800/login/login.jsp");
		return this;
	}

	// This function is to enter username
	public LoginPage enterUsername(String Username) throws Exception {
		element = element(username, "name");
		element.clear();
		element.sendKeys(Username);
		assertEquals(Username, element.getAttribute("value"));
		return this;
	}

	// This function is to enter password
	public LoginPage enterPassword(String Password) throws Exception {
		element = element(password, "name");
		element.clear();
		element.sendKeys(Password);
		assertEquals(Password, element.getAttribute("value"));
		return this;
	}

	// This function is to click on login button
	public LoginPage clickLoginButton() throws Exception {
		element = element(loginbutton, "id");
		element.click();
		return this;
	}

	public LoginPage login(String Username, String Password)
			throws Exception {
		enterUsername(Username);
		enterPassword(Password);
		clickLoginButton();
		
		return this;
	}

	// This function is to accept agreement for new user
	public LoginPage acceptAgreement() throws Exception {
		Thread.sleep(3000);
		element = element(accept, "xpath");
		element.click();
		return this;
	}

	// This function is to enter new password on edit password form
	public LoginPage enterNewPassword(String newPassword) throws Exception {
		element = element(newpassword, "name");
		element.clear();
		element.sendKeys(newPassword);
		assertEquals(newPassword, element.getAttribute("value"));
		return this;
	}

	// This function is to confirm new password on edit password form
	public LoginPage enterConfirmPassword(String confirmPassword)
			throws Exception {
		element = element(confirmnewpassword, "name");
		element.clear();
		element.sendKeys(confirmPassword);
		assertEquals(confirmPassword, element.getAttribute("value"));
		return this;
	}

	// This function is to select submit button on edit password form
	public LoginPage selectSubmit() throws Exception {
		element = element(submitbutton, "id");
		element.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		return this;
	}

	// This function is to reset the password for new user login
	public LoginPage passwordReset(String Password, String newPassword)
			throws Exception {
		Thread.sleep(2000);
		enterPassword(Password);
		enterNewPassword(newPassword);
		enterConfirmPassword(newPassword);
		selectSubmit();
		Thread.sleep(2000);
		return this;
	}
}