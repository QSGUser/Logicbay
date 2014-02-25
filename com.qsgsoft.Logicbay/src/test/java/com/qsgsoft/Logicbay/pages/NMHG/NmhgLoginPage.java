package com.qsgsoft.Logicbay.pages.NMHG;
import java.util.concurrent.TimeUnit;
import com.qsgsoft.Logicbay.pages.Core.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NmhgLoginPage extends LoginPage{
	private static String loginbutton="cmdLogin";
	
	public void clickLoginButton(WebDriver driver) throws Exception{
		driver.findElement(By.id(loginbutton)).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);		
	}
	public void loginToNMHG(WebDriver driver, String strUsername, String strPassword)
			throws Exception {
		enterUsername(driver, strUsername);
		enterPassword(driver, strPassword);
		clickLoginButton(driver);	
	}	
}
