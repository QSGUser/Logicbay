package com.qsgsoft.Logicbay.pages.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qsgsoft.Logicbay.support.URLInterface;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class LoginPage extends WaitForElement implements URLInterface {
	private static String username = "username";
	private static String password = "password";
	private static String loginbutton = "cmdLogin";
	private static String accept = "//input[@name='okbutton']";
	private static String newpassword = "new_password";
	private static String confirmnewpassword = "confirm_new_password";
	private static String submitbutton = "iSubmit";

	public WebDriver driver;

	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void openURL() throws Exception {
		this.driver.get("http://lbapp01.logicbay.com/pc800/login/login.jsp");
		assertTrue(isElementPresent(By.name(username), driver));
	}

	public void enterUsername(String strUsername) throws Exception {
		driver.findElement(By.name(username)).clear();
		driver.findElement(By.name(username)).sendKeys(strUsername);
		assertEquals(strUsername, driver.findElement(By.name(username))
				.getAttribute("value"));
	}

	public void enterPassword(String strPassword) throws Exception {
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.name(password))
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

	public void enterNewPassword(String strnewPassword) throws Exception {
		driver.findElement(By.name(newpassword)).clear();
		driver.findElement(By.name(newpassword)).sendKeys(strnewPassword);
		assertEquals(strnewPassword, driver.findElement(By.name(newpassword))
				.getAttribute("value"));
	}

	public void enterConfirmPassword(String strconfirmPassword)
			throws Exception {
		driver.findElement(By.name(confirmnewpassword)).clear();
		driver.findElement(By.name(confirmnewpassword)).sendKeys(
				strconfirmPassword);
		assertEquals(
				strconfirmPassword,
				driver.findElement(By.name(confirmnewpassword)).getAttribute(
						"value"));
	}

	public void selectSubmit() throws Exception {
		driver.findElement(By.id(submitbutton));
		driver.findElement(By.id(submitbutton)).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}

	public void passwordReset(String strPassword, String strnewPassword)
			throws Exception {
		Thread.sleep(2000);
		enterPassword(strPassword);
		enterNewPassword(strnewPassword);
		enterConfirmPassword(strnewPassword);
		selectSubmit();
	}
}