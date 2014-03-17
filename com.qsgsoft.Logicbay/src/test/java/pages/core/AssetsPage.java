package pages.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import lib.WebElements;

public class AssetsPage extends WebElements {
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
			assetPagetitle="Choose Asset",
			selectAssetLink = "//table[@id='assetTable']/tbody/tr[contains(text(),linkTitle)]",
			enablebutton = "//img[@src='../images/admin/controls/active_dis.gif']",
			mainFramename = "main", detailsFramename = "details";
	public static WebDriver driver;
	WebElement element;

	public AssetsPage(WebDriver _driver) {
		super(_driver);
		AssetsPage.driver = _driver;
	}

	// Function to create new asset
	public AssetsPage createNewAsset(String linkTitle,
			String contentType, String url) throws Exception {
		selectNewAsset();
		enterLinkTitle(linkTitle);
		selectContentType(contentType);
		enterURL(url);
		selectSave();
		return this;
	}

	// Function to map quick link to assets
	public AssetsPage mapLinkToAsset(String linkTitle)
			throws Exception {
		selectquicklink();
		selectnew();
		chooseAsset(linkTitle);
		enableLink(linkTitle);
		return this;
	}

	// Function to select new asset option
	public AssetsPage selectNewAsset() throws Exception {
		Actions action = new Actions(driver);
		switchToFrame(mainFramename, "id");
		element = getElement(newAsset, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	// Function to enter quick link title
	public AssetsPage enterLinkTitle(String linkTitle)
			throws Exception {
		switchToFrame(detailsFramename, "id");
		element = getElement(title, "name");
		element.clear();
		element.sendKeys(linkTitle);
		assertEquals(linkTitle, element.getAttribute("value"));
		return this;
	}

	// Function to select content type for quick link
	public AssetsPage selectContentType(String contentType)
			throws Exception {
		assertTrue(isElementPresent(By.name(contenttype)));
		element = getElement(contenttype, "name");
		new Select(element).selectByVisibleText(contentType);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(contentType));
		return this;
	}

	// Function to enter quicklink URL
	public AssetsPage enterURL(String url) throws Exception {
		element = getElement(urlfield, "name");
		element.clear();
		element.sendKeys(url);
		assertEquals(url, element.getAttribute("value"));
		return this;
	}

	// Function to save the changes
	public AssetsPage selectSave() throws Exception {
		element = getElement(savebutton, "name");
		element.click();
		return this;
	}

	// Function to select quick links option on Quick links page
	public AssetsPage selectquicklink() throws Exception {
		switchToFrame(mainFramename, "id");
		element = getElement(quicklink, "xpath");
		element.click();
		return this;
	}

	// Function to select new option to craeet quicklink
	public AssetsPage selectnew() throws Exception {
		element = getElement(selectNew, "xpath");
		element.click();
		return this;
	}

	// Function to choose asset
	public AssetsPage chooseAsset(String linkTitle) throws Exception {
		switchToFrame(detailsFramename, "id");
		String mainWindowHandle = driver.getWindowHandle();
		element = getElement(chooseAsset, "css");
		element.click();
		Thread.sleep(3000);
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		String assetMenu = driver.getTitle();
		assertTrue(assetMenu.contains(assetPagetitle));
		searchAsset(linkTitle);
		switchToFrame(detailsFramename, "id");
		selectSave();
		return this;
	}

	public AssetsPage searchAsset(String linkTitle) throws Exception {
		element = getElement(mainFramename, "id");
		driver.switchTo().frame(element);
		element = getElement(searchfield, "xpath");
		element.clear();
		element.sendKeys(linkTitle);
		selectGobutton();
		selectAssetlink(linkTitle);
		return this;
	}

	// Function to select 'go' button on chosse asset page
	public AssetsPage selectGobutton() throws Exception {
		element = getElement(gobutton, "id");
		element.click();
		return this;
	}

	// Function to enable created quick link
	public AssetsPage enableLink(String linkTitle) throws Exception {
		switchToFrame(mainFramename, "id");
		element = getElement(enablebutton, "xpath");
		element.click();
		return this;
	}

	// Function to select quicklink from choose asset page
	public AssetsPage selectAssetlink(String linkTitle)
			throws Exception {
		element = getElement(selectAssetLink, "xpath");
		element.click();
		return this;
	}
}