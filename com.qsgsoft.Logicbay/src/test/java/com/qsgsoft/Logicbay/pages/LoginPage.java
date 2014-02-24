package com.qsgsoft.Logicbay.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class LoginPage extends WaitForElement{
	private static String username="//input[@name='username']";
	private static String password="//input[@name='password']";
	private static String loginbutton="//input[@value='Login']";
	private static String url="https://dpcstage.logicbay.com/dlms/login/landing.jsp?backdoor=yes";

	//NMHG server login element id's
	private static String nmhgusername="//input[@id=\"username\"]";
	private static String nmhgpassword="//input[@name='password']";
	private static String nmhgloginbutton="//input[@id='cmdLogin']";
	private static String nmhgurl="http://test.materialshandlingcentral.com/nmhgstg";

	public void launchURL(WebDriver driver) throws Exception {
		driver.get(url);
		waitForElement(driver, username);
		assertTrue(isElementPresent(By.xpath(username), driver));
	}
	
	public void enterUsername(WebDriver driver, String strUsername)
			throws Exception {
		waitForElement(driver, username);
		driver.findElement(By.xpath(username)).clear();
		driver.findElement(By.xpath(username)).sendKeys(strUsername);
		assertEquals(strUsername, driver.findElement(By.xpath(username))
				.getAttribute("value"));
	}

	public void enterPassword(WebDriver driver,String strPassword) throws Exception{
		waitForElement(driver,password);
		driver.findElement(By.xpath(password)).clear();
		driver.findElement(By.xpath(password)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.xpath(password)).getAttribute("value"));
	}

	public void clickLoginButton(WebDriver driver) throws Exception{
		waitForElement(driver,loginbutton);
		driver.findElement(By.xpath(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);		
	}

	public void login(WebDriver driver, String strUsername, String strPassword)
			throws Exception {
		enterUsername(driver, strUsername);
		enterPassword(driver, strPassword);
		clickLoginButton(driver);	
	}
	
	public void launchNmhgURL(WebDriver driver) throws Exception {
		driver.get(nmhgurl);
		waitForElement(driver, nmhgusername);
		assertTrue(isElementPresent(By.xpath(nmhgusername), driver));
	}

	public void enterNmhgUsername(WebDriver driver, String strUsername)
			throws Exception {
		waitForElement(driver, nmhgusername);
		driver.findElement(By.xpath(nmhgusername)).clear();
		driver.findElement(By.xpath(nmhgusername)).sendKeys(strUsername);
		assertEquals(strUsername, driver.findElement(By.xpath(nmhgusername))
				.getAttribute("value"));
	}
	
	public void enterNmhgPassword(WebDriver driver, String strPassword)
			throws Exception {
		waitForElement(driver, nmhgpassword);
		driver.findElement(By.xpath(nmhgpassword)).clear();
		driver.findElement(By.xpath(nmhgpassword)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.xpath(nmhgpassword))
				.getAttribute("value"));
	}
	public void clickNmhgLoginButton(WebDriver driver) throws Exception{
		waitForElement(driver,nmhgloginbutton);
		driver.findElement(By.xpath(nmhgloginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);		
	}

	public void nmhglogin(WebDriver driver, String strUsername, String strPassword)
			throws Exception {
		enterNmhgUsername(driver, strUsername);
		enterNmhgPassword(driver, strPassword);
		clickNmhgLoginButton(driver);	
	}
	
	
}
