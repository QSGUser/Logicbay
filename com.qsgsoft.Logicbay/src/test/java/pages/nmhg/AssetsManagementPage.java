package pages.nmhg;

import org.openqa.selenium.WebDriver;

public class AssetsManagementPage extends pages.core.AssetsManagementPage{

	public AssetsManagementPage(WebDriver _driver) {
		super(_driver);
		AssetsManagementPage.driver = _driver;
	}
}
