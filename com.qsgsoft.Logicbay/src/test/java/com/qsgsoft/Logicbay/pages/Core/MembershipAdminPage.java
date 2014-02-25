package com.qsgsoft.Logicbay.pages.Core;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class MembershipAdminPage extends WaitForElement{
	private static String centerMembership="//div[@id='tab_data_6']/table/tbody/tr[2]/td[1]";
	private static String organizationMembership="//div[@id='tab_data_6']/table/tbody/tr[4]/td[1]";
	private static String getItems="btnGetItems";
	private static String selectSrc="//select[@name='srcList'][@class='cListField']/option[@value='1']";						
	private static String checkTarget="//form/table[3]/tbody/tr[2]/td[3]/select[@name='trgtList']";
	private static String moveRight="//input[@id='move_right']";
	private static String selectSubmit="//input[@type='button'][@value='Submit']";
	private static String selectReturn="//td[@class='cListControlPanel']/a";
	private static String organizationMemebership="//div[@id='tab_data_6']/table/tbody/tr[5]/td[1]";
	
	public void selectcenterMembership(WebDriver driver)throws Exception{
		driver.findElement(By.xpath(centerMembership)).click();	
		driver.switchTo().alert().accept();		
		selectgetItems(driver);
		selectsrcToMap(driver);
		selectMap(driver);
		assertTrue(isElementPresent(By.xpath(checkTarget), driver));
	}
	public void selectgetItems(WebDriver driver)throws Exception{
		driver.findElement(By.id(getItems)).click();
	}
	
	public void selectorganziationMembership(WebDriver driver)throws Exception{	
		driver.findElement(By.xpath(organizationMembership)).click();	
		driver.switchTo().alert().accept();		
	}
	public void selectSubmitOnMapping(WebDriver driver)throws Exception{
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(selectSubmit));
		action.moveToElement(driver.findElement(By.xpath(selectSubmit))).click().build().perform();	
	}
	public void selectReturnOnMapping(WebDriver driver)throws Exception{
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(selectReturn));
		action.moveToElement(driver.findElement(By.xpath(selectReturn))).click().build().perform();	
	}
	public void selectsrcToMap(WebDriver driver)throws Exception{
		try{
			assertTrue(isElementPresent(By.xpath(selectSrc),driver));
			driver.findElement(By.xpath(selectSrc)).click();
		}
		catch (AssertionError e){
			System.out.println("Element Not Found");
		}
	}
	public void selectMap(WebDriver driver)throws Exception{
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(moveRight));
		action.moveToElement(driver.findElement(By.xpath(moveRight))).click().build().perform();
	}
	
	public void selectorganizationMemebership(WebDriver driver)throws Exception{
		driver.findElement(By.xpath(organizationMemebership)).click();	
		driver.switchTo().alert().accept();	
		selectgetItems(driver);
		selectsrcToMap(driver);	
		selectMap(driver);
		assertTrue(isElementPresent(By.xpath(checkTarget), driver));
	}
}
