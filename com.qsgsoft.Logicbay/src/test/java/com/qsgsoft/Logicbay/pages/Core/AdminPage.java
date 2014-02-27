package com.qsgsoft.Logicbay.pages.Core;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class AdminPage extends WaitForElement{
	private static String selectUsers="//img[@id='catBullet6']";
	private static String selectAddUsers="//td[@id='addLTUser']";
	private static String selectReturn="//td[@id='adminLink2']";

	public void SelectUserAdmin(WebDriver driver) throws Exception{		
		selectUser(driver);
		selectAddUser(driver);
	}	
	public void selectUser(WebDriver driver) throws Exception{	
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.switchTo().window("");	
		driver.switchTo().frame(driver.findElement(By.id("contents")));	
		action.moveToElement(driver.findElement(By.xpath(selectUsers))).click().build().perform();
	}
	public void selectAddUser(WebDriver driver) throws Exception{
		assertTrue(isElementPresent(By.xpath(selectAddUsers),driver));
		driver.findElement(By.xpath(selectAddUsers)).click();	
	}	
	public void returnToHome(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.switchTo().window("");	
		driver.switchTo().frame(driver.findElement(By.id("contents")));	
		driver.findElement(By.xpath(selectReturn)).click();
	}		
}