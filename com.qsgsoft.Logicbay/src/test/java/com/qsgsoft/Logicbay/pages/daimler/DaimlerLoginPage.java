package com.qsgsoft.Logicbay.pages.daimler;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import org.openqa.selenium.interactions.Actions;

public class DaimlerLoginPage extends LoginPage {
	private static String loginbutton = "submitImg";
	private static String password = "//input[@name='password'][@type='password']";

	public static WebDriver driver;

	public DaimlerLoginPage(WebDriver _driver) {
		super(driver);
	}

	public void openURL() throws Exception {
		driver.get("http://lbapp10.logicbay.com/daimler_preprod/login/login.jsp");
	}

	public void loginToDaimler(String strUsername, String strPassword)
			throws Exception {
		enterUsername(strUsername);
		enterPassword(strPassword);
		clickLoginButton();
	}

	public void clickLoginButton() throws Exception {
		driver.findElement(By.name(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}

	public void enterNewPassword(String strPassword) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(password)));
		driver.findElement(By.xpath(password)).clear();
		driver.findElement(By.xpath(password)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.xpath(password))
				.getAttribute("value"));
	}

	public void switchToWindow() throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
	}

}