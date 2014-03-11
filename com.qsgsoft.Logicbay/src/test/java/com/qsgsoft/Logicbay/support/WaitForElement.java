package com.qsgsoft.Logicbay.support;
import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class WaitForElement {
	public static String pageLoad = "90000";
	public static String pageLoadNotWorks = "60000";
	
	public void waitForElement(WebDriver driver, String strElement) throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.xpath(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 20);
	}
	
	public void waitForElementBycssSelector(WebDriver driver, String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.cssSelector(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 20);
	}
	
	public void waitForText(WebDriver driver, String strElementID, String strText)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				assertTrue(driver.findElement(By.xpath(strElementID)).getText().contains(strText));
				break;
			} catch (AssertionError e) {
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 20);
	}
	
	public void waitForTextByCssSelector(WebDriver driver, String strElementID, String strText)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				assertTrue(driver.findElement(By.cssSelector(strElementID)).getText().contains(strText));
				break;
			} catch (AssertionError e) {
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 20);
	}
	
	public boolean isElementPresent(By by,WebDriver driver) throws InvocationTargetException{
		@SuppressWarnings("unused")
		int intCnt=0;
		boolean blnFound=false;
		try{				
			try {				
				driver.findElement(by);					
				blnFound =true;
				
			} catch (NoSuchElementException e) {				
				intCnt++;
				Thread.sleep(1000);			
				blnFound=false;
				
			} catch (StaleElementReferenceException e){
				intCnt++;
				Thread.sleep(1000);
				blnFound=false;	
			} catch (InvalidElementStateException e){
				intCnt++;
				Thread.sleep(1000);
				blnFound=false;
			}	
		}catch(Exception E){
			
		}
		return blnFound;
	}		
	public void waitForLoading(WebDriver driver)
	{
		int intCntr=0;
		try{
			WebElement btn=driver.findElement((By.xpath("//div[@id='WaitMessage']")));
			while (intCntr<=200) 
			{
				try{
					btn.isEnabled();
					btn.isDisplayed();
					intCntr++;
					Thread.sleep(1000);
				}catch(Exception e){
					waitForPageToLoad(driver);
					Thread.sleep(3000);
					break; 
				}    
			}
		}catch(Exception e)
		{

		}	
	}	
	public void waitForPageToLoad(WebDriver driver) throws Exception{
		@SuppressWarnings("unused")
		boolean blnPageLoaded;
		do
		{
			blnPageLoaded=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		}while(blnPageLoaded=false);
	}
}