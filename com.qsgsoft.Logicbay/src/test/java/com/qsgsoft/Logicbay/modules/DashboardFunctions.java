package com.qsgsoft.Logicbay.modules;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class DashboardFunctions extends WaitForElement{	
	private static String logoff="logout_link";
	private static String myprofile="profile_link";

	public void logOff(WebDriver driver)throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.switchTo().window("");	
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));	
		action.moveToElement(driver.findElement(By.id(logoff))).click().build().perform();
	}
	
	public void selectMyProfile(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.switchTo().window("Edit Profile");
		driver.switchTo().frame(driver.findElement(By.name("profile")));	
		action.moveToElement(driver.findElement(By.id(myprofile))).click().build().perform();
		Thread.sleep(1000);
	}
}
