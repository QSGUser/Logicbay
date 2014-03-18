package pages.daimler;

import org.openqa.selenium.WebDriver;

public class AdminPage extends pages.core.AdminPage{

	public AdminPage(WebDriver _driver) {
		super(_driver);
		this.driver=_driver;
	}
}
