package com.qsgsoft.Logicbay.pages.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.URLInterface;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class LoginPage extends WaitForElement implements URLInterface {
	private String username = "username", password = "password",
			loginbutton = "cmdLogin", accept = "//input[@name='okbutton']",
			newpassword = "new_password",
			confirmnewpassword = "confirm_new_password",
			submitbutton = "iSubmit";
	public WebDriver driver;

	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public LoginPage openURL() throws Exception {
		this.driver.get("http://lbapp01.logicbay.com/pc800/login/login.jsp");
		assertTrue(isElementPresent(By.name(username), driver));
		return this;
	}

	// This function is to enter username
	public LoginPage enterUsername(String Username) throws Exception {
		driver.findElement(By.name(username)).clear();
		driver.findElement(By.name(username)).sendKeys(Username);
		assertEquals(Username, driver.findElement(By.name(username))
				.getAttribute("value"));
		return this;
	}

	// This function is to enter password
	public LoginPage enterPassword(String Password) throws Exception {
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys(Password);
		assertEquals(Password, driver.findElement(By.name(password))
				.getAttribute("value"));
		return this;
	}

	// This function is to click on login button
	public LoginPage clickLoginButton() throws Exception {
		driver.findElement(By.id(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		return this;
	}

	public LoginPage login(String strUsername, String strPassword)
			throws Exception {
		enterUsername(strUsername);
		enterPassword(strPassword);
		clickLoginButton();
		return this;
	}

	// This function is to accept agreement for new user
	public LoginPage acceptAgreement() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(accept));
		driver.findElement(By.xpath(accept)).click();
		return this;
	}

	// This function is to enter new password on edit password form
	public LoginPage enterNewPassword(String newPassword) throws Exception {
		driver.findElement(By.name(newpassword)).clear();
		driver.findElement(By.name(newpassword)).sendKeys(newPassword);
		assertEquals(newPassword, driver.findElement(By.name(newpassword))
				.getAttribute("value"));
		return this;
	}

	// This function is to confirm new password on edit password form
	public LoginPage enterConfirmPassword(String confirmPassword) throws Exception {
		driver.findElement(By.name(confirmnewpassword)).clear();
		driver.findElement(By.name(confirmnewpassword)).sendKeys(
				confirmPassword);
		assertEquals(
				confirmPassword,
				driver.findElement(By.name(confirmnewpassword)).getAttribute(
						"value"));
		return this;
	}

	// This function is to select submit button on edit password form
	public LoginPage selectSubmit() throws Exception {
		driver.findElement(By.id(submitbutton));
		driver.findElement(By.id(submitbutton)).click();
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