package com.qsgsoft.Logicbay.pages.daimler;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.pages.core.LoginPage;
import org.openqa.selenium.interactions.Actions;

public class DaimlerLoginPage extends LoginPage {
	private static String loginbutton = "submitImg";
	private static String password ="password";
	private static String loginArrowfield="//input[@src='/daimler_preprod/content/documents/campus_8/pc_html_images/login_btn.png']";
	private static String agreefield="agree";
	private static String okfield="okbutton";
	public static WebDriver driver;

	public DaimlerLoginPage(WebDriver _driver) {
		super(_driver);
		DaimlerLoginPage.driver = _driver;
	}

	public void openURL(WebDriver driver) throws Exception {
		driver.get("http://lbapp10.logicbay.com/daimler_preprod/login/login.jsp");
	}

	public void loginToDaimler(String strUsername, String strPassword)
			throws Exception {
		this.enterUsername(strUsername);
		enterPassword(strPassword);
		clickLoginButton();
	}
	
	public void loginAsMember(String emailAddress,String Password)throws Exception{
		switchToWindow();
		enterUsername(emailAddress);
		enterNewPassword(Password);
		clickMemberLogin();
	}

	public void clickLoginButton() throws Exception {
		driver.findElement(By.name(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}

	public void enterNewPassword(String strPassword) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.name(password))).click().perform();
	/*	driver.findElement(By.name(password)).clear();*/
		driver.findElement(By.name(password)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.name(password))
				.getAttribute("value"));
	}

	public void switchToWindow() throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
	}
	
	public void clickMemberLogin()throws Exception{
		driver.findElement(By.xpath(loginArrowfield)).click();
	}
	
	public void acceptAgreement()throws Exception{
		driver.findElement(By.name(agreefield)).click();
		driver.findElement(By.name(okfield)).click();
	}
}