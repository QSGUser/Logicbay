package com.qsgsoft.Logicbay.modules;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class DashboardFunctions extends WaitForElement{	
	private static String logoff="logout_link";
	private static String myprofile="profile_link";
	//Function to logout from application
	public void logOff(WebDriver driver)throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.switchTo().window("");	
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));	
		action.moveToElement(driver.findElement(By.id(logoff))).click().build().perform();
	}
	//Function to select my profile
	public void selectMyProfile(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int i = 0;
		do{
			driver.switchTo().alert().dismiss();	
			Thread.sleep(1000);
			i++;
		}while(i<=5);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));
		driver.findElement((By.id(myprofile)));
		action.moveToElement(driver.findElement(By.id(myprofile))).click().build().perform();
		driver.switchTo().window("");
	}
}