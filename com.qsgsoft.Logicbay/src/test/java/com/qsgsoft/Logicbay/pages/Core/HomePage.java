package com.qsgsoft.Logicbay.pages.Core;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.WaitForElement;
import static org.junit.Assert.*;

public class HomePage extends WaitForElement{
	private static String selectCampusTab="//tr[@id='javascriptMenuTop']/td[6]";
	private static String selectAdmin="td[id=\"_PCMM_ID_96_text\"][class=\"Menu_DynamicRule2\"]";
	
	public void SalesPerformancePage(WebDriver driver) throws Exception {
		selectCampus(driver);
		selectAdmin(driver);
	}
	public void selectCampus(WebDriver driver) throws Exception{
		Actions action = new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.id("topFrame")));
		String frameId = null;
		List<WebElement> frameSet = driver.findElements(By.tagName("iframe"));  
		for (WebElement frameName : frameSet){  
		    if(!(frameName.getAttribute("id").isEmpty()) && (frameName.getAttribute("id").contains("DlgFrame"))){
		            frameId = frameName.getAttribute("id");
		        }
		}
		try {
		    Thread.sleep(10000);
		    } catch (InterruptedException e) {
		    e.printStackTrace();
		    }
		driver.switchTo().frame("leftSide");
		driver.switchTo().frame("topFrame");
		assertTrue(isElementPresent(By.xpath(selectCampusTab), driver));
		action.moveToElement(driver.findElement(By.xpath(selectCampusTab))).click().build().perform();
	}
	public void selectAdmin(WebDriver driver) throws Exception{
		//assertTrue(isElementPresent(By.xpath(selectAdmin), driver));
		String strSelectedVal = new Select(driver.findElement(By
				.xpath(selectAdmin))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals("Admin"));
	}
}



