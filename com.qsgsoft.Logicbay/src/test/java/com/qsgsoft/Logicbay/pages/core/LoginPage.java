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

	public void openURL() throws Exception {
		this.driver.get("http://lbapp01.logicbay.com/pc800/login/login.jsp");
		assertTrue(isElementPresent(By.name(username), driver));
	}

	public void enterUsername(String Username) throws Exception {
		driver.findElement(By.name(username)).clear();
		driver.findElement(By.name(username)).sendKeys(Username);
		assertEquals(Username, driver.findElement(By.name(username))
				.getAttribute("value"));
	}

	public void enterPassword(String Password) throws Exception {
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys(Password);
		assertEquals(Password, driver.findElement(By.name(password))
				.getAttribute("value"));
	}

	public void clickLoginButton() throws Exception {
		driver.findElement(By.id(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}

	public void login(String strUsername, String strPassword) throws Exception {
		enterUsername(strUsername);
		enterPassword(strPassword);
		clickLoginButton();
	}

	public void acceptAgreement() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(accept));
		driver.findElement(By.xpath(accept)).click();
	}

	public void enterNewPassword(String newPassword) throws Exception {
		driver.findElement(By.name(newpassword)).clear();
		driver.findElement(By.name(newpassword)).sendKeys(newPassword);
		assertEquals(newPassword, driver.findElement(By.name(newpassword))
				.getAttribute("value"));
	}

	public void enterConfirmPassword(String confirmPassword) throws Exception {
		driver.findElement(By.name(confirmnewpassword)).clear();
		driver.findElement(By.name(confirmnewpassword)).sendKeys(
				confirmPassword);
		assertEquals(
				confirmPassword,
				driver.findElement(By.name(confirmnewpassword)).getAttribute(
						"value"));
	}

	public void selectSubmit() throws Exception {
		driver.findElement(By.id(submitbutton));
		driver.findElement(By.id(submitbutton)).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	public void passwordReset(String Password, String newPassword)
			throws Exception {
		Thread.sleep(2000);
		enterPassword(Password);
		enterNewPassword(newPassword);
		enterConfirmPassword(newPassword);
		selectSubmit();
		Thread.sleep(2000);
	}
}