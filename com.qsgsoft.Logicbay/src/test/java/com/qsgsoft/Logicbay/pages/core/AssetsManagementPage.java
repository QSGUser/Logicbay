package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qsgsoft.Logicbay.support.WaitForElement;

public class AssetsManagementPage extends WaitForElement {
	private static String newAsset = "//img[@src='../images/admin/controls/document.gif']";
	private static String title = "title";
	private static String contenttype = "assetTypeId";
	private static String urlfield = "url";
	private static String savebutton = "save";
	private static String assetSearchfield="search_criteria_TXT";
	private static String quicklink="//div[@id='tv']/ul/li/div/span[3]";
	private static String selectNew="//img[@src='../images/admin/controls/document.gif']";
	private static String chooseAsset="chooseAsset";
	public WebDriver driver;

	public AssetsManagementPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void createNewAsset(String linkTitle, String contentType, String url)
			throws Exception {
		selectNewAsset();
		enterLinkTitle(linkTitle);
		selectContentType(contentType);
		enterURL(url);
		selectSave();
	}

	public void selectNewAsset() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("main")));
		driver.findElement(By.xpath(newAsset));
		action.moveToElement(driver.findElement(By.xpath(newAsset))).click()
		.build().perform();
	}

	public void enterLinkTitle(String linkTitle) throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("details")));
		driver.findElement(By.name(title)).clear();
		driver.findElement(By.name(title)).sendKeys(linkTitle);
		assertEquals(linkTitle, driver.findElement(By.name(title))
				.getAttribute("value"));
	}

	public void selectContentType(String contentType) throws Exception {
		assertTrue(isElementPresent(By.name(contenttype), driver));
		new Select(driver.findElement(By.name(contenttype)))
		.selectByVisibleText(contentType);
		String strSelectedVal = new Select(driver.findElement(By
				.name(contenttype))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(contentType));
	}

	public void enterURL(String url) throws Exception {
		driver.findElement(By.name(urlfield)).clear();
		driver.findElement(By.name(urlfield)).sendKeys(url);
		assertEquals(url,
				driver.findElement(By.name(urlfield)).getAttribute("value"));
	}

	public void selectSave() throws Exception {
		driver.findElement(By.name(savebutton)).click();
	}
	
	public void searchAsset(String linkTitle) throws Exception{
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("main")));
		driver.findElement(By.name(assetSearchfield)).clear();
		driver.findElement(By.name(assetSearchfield)).sendKeys(linkTitle);
	}
	public void selectquicklink()throws Exception{
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("main")));
		driver.findElement(By.xpath(quicklink)).click();
	}
	public void selectnew()throws Exception{
		driver.findElement(By.xpath(selectNew)).click();
	}
	public void chooseAsset()throws Exception{
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id("details")));
		driver.findElement(By.name(chooseAsset)).click();
	}
	public void mapLinkToAsset()throws Exception{
		selectquicklink();
		selectnew();
		chooseAsset();
		assetwindow();
	}
	public void assetwindow()throws Exception{
		driver.switchTo().window("Choose Asset");
	}
}