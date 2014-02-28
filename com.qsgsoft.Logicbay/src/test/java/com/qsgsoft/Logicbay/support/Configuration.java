package com.qsgsoft.Logicbay.support;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.After;
import org.junit.Before;
import com.qsgsoft.Logicbay.support.Configuration;

public class Configuration {

	public WebDriver driver;
	public Properties EnvPropertyDetails;
	private String browser;

	@Before
	public void setup() throws Exception {

		ReadEnvironmentProperty objReadEnvironmentProperty = new ReadEnvironmentProperty();
		EnvPropertyDetails = objReadEnvironmentProperty.ReadEnvironment();
		browser = EnvPropertyDetails.getProperty("Browser");

		if (browser.equals("*iexplore")) {
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			System.setProperty("webdriver.ie.driver", System.getProperty(
					"webdriver.ie.driver",
					".//BrowserDrivers//IEDriverServer.exe"));
			driver = new InternetExplorerDriver(cap);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
			driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
		}

		if (browser.equals("*firefox")) {
			// Create a new Firefox Driver session
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		driver.manage().window().maximize();
		return;
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}