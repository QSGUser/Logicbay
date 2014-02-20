package com.qsgsoft.Logicbay.requirement;

//import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.qsgsoft.Logicbay.support.Configuration;
//import com.qsgsoft.Logicbay.support.ReadDataFromExcel;
import com.qsgsoft.Logicbay.pages.*;


public class BQSAddUser extends Configuration{
	
	public WebDriver driver;
	String gstrTO, gstrTCID;

	@Before
	public void setup() throws Exception {
		driver = configuration(driver);
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
		//driver.quit();
	}

	@Test
	public void AddUserToSalesPerformanceCenter() throws Exception{
		
		gstrTCID = "1";
		gstrTO = "Verify that User can be added to Sales Perfromance center";

		// Login credentials
		String strUserName = "qsgadmin";
		String strPassword = "1FishTwoF1$h!";

		// Create page objects
		LoginPage objLoginPage = new LoginPage();
		HomePage objHomePage =new HomePage();
		SelectCampusAdminPage objSelectCampusAdminPage=new SelectCampusAdminPage();

		objLoginPage.launchURL(driver);
		
		objLoginPage.login(driver, strUserName, strPassword);
		
		objSelectCampusAdminPage.SelectCampusAdmin(driver);
		
		objHomePage.SalesPerformancePage(driver);
		
		
	}
}





