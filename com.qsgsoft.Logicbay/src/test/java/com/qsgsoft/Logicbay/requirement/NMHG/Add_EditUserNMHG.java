package com.qsgsoft.Logicbay.requirement.NMHG;
import com.qsgsoft.Logicbay.pages.Core.AdminPage;
import com.qsgsoft.Logicbay.pages.Core.LoginPage;
import com.qsgsoft.Logicbay.pages.NMHG.NmhgHomePage;
import com.qsgsoft.Logicbay.pages.NMHG.NmhgLoginPage;
import com.qsgsoft.Logicbay.pages.NMHG.NmhgUserPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;
import com.qsgsoft.Logicbay.pages.*;

public class Add_EditUserNMHG extends Configuration{
	public WebDriver driver;
	String gstrTO, gstrTCID,url,strAdminUserName,strAdminPassword;
	TestData objTestData = new TestData();

	@Before
	public void setup() throws Exception {
		driver = configuration(driver);
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	@Test
	public void AddUserToNmhgServer() throws Exception{	
		gstrTO="Verify that a user can be added in Performance Center";
		gstrTCID="132534";
		url="http://test.materialshandlingcentral.com/nmhgstg";
		strAdminUserName = objTestData.strNmhgAdminName;
		strAdminPassword = objTestData.strNmhgAdminPassword;
		//Data for creating a contact
		String strUsername=objTestData.strUsername;
		String strEmailAddress=objTestData.strEmailAddress;
		String strFirstName=objTestData.strFirstName;
		String strLastName=objTestData.strLastName;
		String strPassword=objTestData.strPassword;
		String strLocale=objTestData.strLocale;
		String strTimeZone=objTestData.strTimezone;
		String strMemberStatus=objTestData.strMemberstatus;
		String strSystemRole=objTestData.strSystemrole;
		String strJobRole=objTestData.strJobrole;
		String strJobTitle=objTestData.strJobtitle;
		//Creating objects
		LoginPage objLoginPage = new LoginPage();
		NmhgLoginPage objNmhgLoginPage=new NmhgLoginPage();
		NmhgHomePage objNmhgHomePage =new NmhgHomePage();
		AdminPage objAdminPage=new AdminPage();
		NmhgUserPage objNmhgUserPage=new NmhgUserPage();
		
		
		objLoginPage.launchURL(driver,url);

		objNmhgLoginPage.loginToNMHG(driver, strAdminUserName, strAdminPassword);
		
		objNmhgHomePage.NavigateToAdmin(driver);
		
		objAdminPage.SelectUserAdmin(driver);
		
		objNmhgUserPage.NmhgUserCreation(driver,strEmailAddress,strFirstName,strLastName,strPassword,strTimeZone,strLocale,strMemberStatus,strSystemRole,strJobRole,strJobTitle);	
		
	
	}
	
}