package com.qsgsoft.Logicbay.pages.Daimler;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.pages.Core.LoginPage;

public class DaimlerLoginPage extends LoginPage{
	private static String loginbutton="submitImg";
	private static String password="passwordText";

	public void loginToDaimler(WebDriver driver,String strUsername,String strPassword)throws Exception{
		enterUsername(driver, strUsername);
		enterPassword(driver, strPassword);
		clickLoginButton(driver);	
	}
	public void clickLoginButton(WebDriver driver) throws Exception{
		driver.findElement(By.name(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}
	public void enterNewPassword(WebDriver driver,String strPassword) throws Exception{
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys(strPassword);
		assertEquals(strPassword, driver.findElement(By.name(password)).getAttribute("value"));
	}
	public void switchToWindow(WebDriver driver) throws Exception{
		driver.switchTo().window("");	
		driver.switchTo().frame(driver.findElement(By.id("mainFrame")));		
	}
	
}