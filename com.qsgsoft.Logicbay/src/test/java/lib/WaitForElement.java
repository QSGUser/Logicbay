package lib;

import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {
	public WebDriver driver;

	public WaitForElement(WebDriver _driver) {
		this.driver = _driver;
	}

	public void switchToFrame(String frameName, String locator)
			throws Exception {
		switch (locator) {
		case "id":
			driver.switchTo().window("");
			driver.switchTo().frame(driver.findElement(By.id(frameName)));
			break;
		case "name":
			driver.switchTo().window("");
			driver.switchTo().frame(driver.findElement(By.name(frameName)));
			break;
		case "":
			driver.switchTo().frame(frameName);
			break;
		}
	}

	public void waitForElement(String elementId, String locator)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				switch (locator) {
				case "xpath":
					driver.findElement(By.xpath(elementId)).isDisplayed();
					break;
				case "css":
					driver.findElement(By.cssSelector(elementId)).isDisplayed();
					break;
				}
			} catch (Exception e) {
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 10);
	}

	public boolean isElementPresent(By by) throws InvocationTargetException {
		@SuppressWarnings("unused")
		int intCnt = 0;
		boolean blnFound = false;
		try {
			try {
				driver.findElement(by);
				blnFound = true;

			} catch (NoSuchElementException e) {
				intCnt++;
				Thread.sleep(1000);
				blnFound = false;

			} catch (StaleElementReferenceException e) {
				intCnt++;
				Thread.sleep(1000);
				blnFound = false;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
				blnFound = false;
			}
		} catch (Exception E) {
		}
		return blnFound;
	}

	public void waitForPageToLoad() throws Exception {
		@SuppressWarnings("unused")
		boolean blnPageLoaded;
		do {
			blnPageLoaded = ((JavascriptExecutor) driver).executeScript(
					"return document.readyState").equals("complete");
		} while (blnPageLoaded = false);
	}
	
	public void handleAlert()throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 300);
		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("alert was not present");
		} else {
			driver.switchTo().alert().accept();
		}
	}
}