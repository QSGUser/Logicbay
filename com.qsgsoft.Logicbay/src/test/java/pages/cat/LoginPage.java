package pages.cat;

import org.openqa.selenium.WebDriver;

public class LoginPage extends pages.core.LoginPage{
	private String loginbutton="//input[@type='submit']";
	
	public LoginPage(WebDriver _driver) {
		super(_driver);
		this.driver=_driver;
	}
	public LoginPage openURL() throws Exception {
		driver.get("https://dpcstage.logicbay.com/dlms/login/landing.jsp?backdoor=yes");
		return this;
	}
	
	public LoginPage clickLoginButton() throws Exception {
		element=getElement(loginbutton,"xpath");
		element.click();
		return this;
	}
	
	public LoginPage login(String Username,String Password)throws Exception{
		this.enterUsername(Username);
		enterPassword(Password);
		clickLoginButton();
		return this;
	}
}
