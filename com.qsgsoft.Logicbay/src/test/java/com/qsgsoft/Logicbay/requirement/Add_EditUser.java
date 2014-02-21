package com.qsgsoft.Logicbay.requirement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.ReadDataFromExcel;
import com.qsgsoft.Logicbay.support.TestData;
import com.qsgsoft.Logicbay.pages.*;

public class Add_EditUser extends Configuration{
	public WebDriver driver;
	ReadDataFromExcel objrdExcel;
	String gstrTO, gstrTCID;
	TestData objTestData = new TestData();

	@Before
	public void setup() throws Exception {
		driver = configuration(driver);
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
		//driver.quit();
	}
	@Test
	public void AddUserToSalesPerformanceCenter() throws Exception{	
		gstrTCID = "132534";
		gstrTO = "Verify that a user can be added in Performance Center";
		// Login credentials
		String strUserName = objTestData.strAdminName;
		String strPassword = objTestData.strAdminPswd;
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