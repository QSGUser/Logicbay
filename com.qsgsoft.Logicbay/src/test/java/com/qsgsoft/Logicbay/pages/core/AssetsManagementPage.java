package com.qsgsoft.Logicbay.pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.qsgsoft.Logicbay.support.WaitForElement;

public class AssetsManagementPage extends WaitForElement {
	private String newAsset = "//img[@src='../images/admin/controls/document.gif']",
			title = "title",
			contenttype = "assetTypeId",
			urlfield = "url",
			savebutton = "save",
			quicklink = "//div[@id='tv']/ul/li/div/span[3]",
			selectNew = "//img[@src='../images/admin/controls/document.gif']",
			chooseAsset = "div#assetField2>input[name='chooseAsset']",
			searchfield = "//input[@id='search_criteria_TXT']",
			gobutton = "search_go",
			selectAssetLink = "//table[@id='assetTable']/tbody/tr[contains(text(),linkTitle)]",
			enablebutton = "//img[@src='../images/admin/controls/active_dis.gif']";
	public static WebDriver driver;

	public AssetsManagementPage(WebDriver _driver) {
		AssetsManagementPage.driver = _driver;
	}

	// Function to switch to other frames on the page
	public AssetsManagementPage switchToFrame(String FrameName)
			throws Exception {
		driver.switchTo().window("");
		driver.switchTo().frame(driver.findElement(By.id(FrameName)));
		return this;
	}

	// Function to create new asset
	public AssetsManagementPage createNewAsset(String linkTitle,
			String contentType, String url) throws Exception {
		selectNewAsset();
		enterLinkTitle(linkTitle);
		selectContentType(contentType);
		enterURL(url);
		selectSave();
		return this;
	}

	// Function to map quick link to assets
	public AssetsManagementPage mapLinkToAsset(String linkTitle)
			throws Exception {
		selectquicklink();
		selectnew();
		chooseAsset(linkTitle);
		enableLink(linkTitle);
		return this;
	}

	// Function to select new asset option
	public AssetsManagementPage selectNewAsset() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switchToFrame("main");
		driver.findElement(By.xpath(newAsset));
		action.moveToElement(driver.findElement(By.xpath(newAsset))).click()
				.build().perform();
		return this;
	}

	// Function to enter quick link title
	public AssetsManagementPage enterLinkTitle(String linkTitle)
			throws Exception {
		switchToFrame("details");
		driver.findElement(By.name(title)).clear();
		driver.findElement(By.name(title)).sendKeys(linkTitle);
		assertEquals(linkTitle, driver.findElement(By.name(title))
				.getAttribute("value"));
		return this;
	}

	// Function to select content type for quick link
	public AssetsManagementPage selectContentType(String contentType)
			throws Exception {
		assertTrue(isElementPresent(By.name(contenttype), driver));
		new Select(driver.findElement(By.name(contenttype)))
				.selectByVisibleText(contentType);
		String strSelectedVal = new Select(driver.findElement(By
				.name(contenttype))).getFirstSelectedOption().getText();
		assertTrue(strSelectedVal.equals(contentType));
		return this;
	}

	// Function to enter quicklink URL
	public AssetsManagementPage enterURL(String url) throws Exception {
		driver.findElement(By.name(urlfield)).clear();
		driver.findElement(By.name(urlfield)).sendKeys(url);
		assertEquals(url,
				driver.findElement(By.name(urlfield)).getAttribute("value"));
		return this;
	}

	// Function to save the changes
	public AssetsManagementPage selectSave() throws Exception {
		driver.findElement(By.name(savebutton)).click();
		return this;
	}

	// Function to select quick links option on Quick links page
	public AssetsManagementPage selectquicklink() throws Exception {
		switchToFrame("main");
		driver.findElement(By.xpath(quicklink)).click();
		return this;
	}

	// Function to select new option to craeet quicklink
	public AssetsManagementPage selectnew() throws Exception {
		driver.findElement(By.xpath(selectNew)).click();
		return this;
	}

	// Function to choose asset
	public AssetsManagementPage chooseAsset(String linkTitle) throws Exception {
		switchToFrame("details");
		String mainWindowHandle = driver.getWindowHandle();
		driver.findElement(By.cssSelector(chooseAsset)).click();
		Thread.sleep(5000);
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		String assetMenu = driver.getTitle();
		assertTrue(assetMenu.contains("Choose Asset"));
		driver.switchTo().frame(driver.findElement(By.id("main")));
		driver.findElement(By.xpath(searchfield)).clear();
		driver.findElement(By.xpath(searchfield)).sendKeys(linkTitle);
		selectGobutton();
		selectAssetlink(linkTitle);
		switchToFrame("details");
		selectSave();
		return this;
	}

	// Function to select 'go' button on chosse asset page
	public AssetsManagementPage selectGobutton() throws Exception {
		driver.findElement(By.id(gobutton)).click();
		return this;
	}

	// Function to enable created quick link
	public AssetsManagementPage enableLink(String linkTitle) throws Exception {
		switchToFrame("main");
		Thread.sleep(1000);
		driver.findElement(By.xpath(enablebutton)).click();
		Thread.sleep(1000);
		return this;
	}

	// Function to select quicklink from choose asset page
	public AssetsManagementPage selectAssetlink(String linkTitle)
			throws Exception {
		driver.findElement(By.xpath(selectAssetLink)).click();
		return this;
	}
}