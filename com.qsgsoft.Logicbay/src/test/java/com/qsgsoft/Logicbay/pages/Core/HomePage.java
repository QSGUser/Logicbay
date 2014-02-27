package com.qsgsoft.Logicbay.pages.Core;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class HomePage extends WaitForElement{
	private static String CampusTab="_PCMM_TabText_4";
	private static String Admin="_PCMM_ID_52_text";
	
	public void NavigateToAdmin(WebDriver driver) throws Exception {
		selectCampusTab(driver);
		selectAdmin(driver);
	}
	public void selectCampusTab(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.switchTo().window("");	
		driver.switchTo().frame(driver.findElement(By.name("topFrame")));		
		action.moveToElement(driver.findElement(By.id(CampusTab))).click().build().perform();		
	}
	public void selectAdmin(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);	
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.name("mainFrame")));
		driver.switchTo().frame("menuiframe_4");
		action.moveToElement(driver.findElement(By.id(Admin))).click().build().perform();	
	}
}



