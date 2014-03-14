package com.qsgsoft.Logicbay.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lib.WaitForElement;

public class WebElements extends WaitForElement {

	public WebElements(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public WebElement element(String elementId, String locatorStrategy)
			throws Exception {
		WebElement element = null;
		switch (locatorStrategy) {
		case "xpath":
			element = driver.findElement(By.xpath(elementId));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(elementId));
			break;
		case "id":
			element = driver.findElement(By.id(elementId));
			break;
		case "name":
			element = driver.findElement(By.name(elementId));
			break;
		case "linktext":
			element = driver.findElement(By.linkText(elementId));
			break;
		}
		return element;
	}
}