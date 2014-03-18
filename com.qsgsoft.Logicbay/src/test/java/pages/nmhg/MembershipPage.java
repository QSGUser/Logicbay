package pages.nmhg;

import org.openqa.selenium.WebDriver;

public class MembershipPage extends
		pages.core.MembershipPage {

	public MembershipPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}
}