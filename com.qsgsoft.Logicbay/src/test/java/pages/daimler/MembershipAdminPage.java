package pages.daimler;

import org.openqa.selenium.WebDriver;

public class MembershipAdminPage extends pages.core.MembershipAdminPage{

	public MembershipAdminPage(WebDriver _driver) {
		super(_driver);
		this.driver=_driver;
	}
}
