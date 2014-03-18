package pages.nmhg;

import org.openqa.selenium.WebDriver;

public class LoginPage extends pages.core.LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver _driver) {
		super(_driver);
		this.driver=_driver;
	}
	public LoginPage openURL() throws Exception {
		driver.get("https://test.materialshandlingcentral.com/nmhgstg/login/login.jsp");
		return this;
	}
	
	// This function is to reset the password for new user login
		public LoginPage passwordReset(String Password, String newPassword)
				throws Exception {
			enterNewPassword(newPassword);
			enterConfirmPassword(newPassword);
			clickSubmit();
			waitForPageToLoad();
			return this;
		}
}
