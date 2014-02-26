package com.qsgsoft.Logicbay.requirement.Core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.modules.DashboardFunctions;
import com.qsgsoft.Logicbay.pages.Core.AdminPage;
import com.qsgsoft.Logicbay.pages.Core.HomePage;
import com.qsgsoft.Logicbay.pages.Core.LoginPage;
import com.qsgsoft.Logicbay.pages.Core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.Core.MyProfilePage;
import com.qsgsoft.Logicbay.pages.Core.UserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

public class Add_EditUserCore extends Configuration {
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
	public void AddUserToCoreServer() throws Exception{	
		gstrTO="Verify that a user can be added in Performance Center";
		gstrTCID="132534";
		url="http://lbapp01.logicbay.com/pc800/";
		strAdminUserName = objTestData.strCoreLoginName;
		strAdminPassword = objTestData.strCorePassword;
		//Data for creating a contact
		String strUserName=objTestData.strUsername;
		String strEmailAddress=objTestData.strEmailAddress;
		String strFirstName=objTestData.strFirstName;
		String strLastName=objTestData.strLastName;
		String strPassword=objTestData.strPassword;
		String strLocale=objTestData.strLocale;
		String strTimeZone=objTestData.strTimezone;
		String strMemberStatus=objTestData.strMemberstatus;
		String strSystemRole=objTestData.strSystemrole;
		String strJobRole=objTestData.strJobrole;
		String strcentersubType=objTestData.strcenterSubtype;
		String strcenterSrc=objTestData.strcenterSrcCore;
		String genderType=objTestData.strgenderType;
		String strnewPassword=objTestData.strnewPassword;
		//Creating objects
		LoginPage objLoginPage = new LoginPage();
		HomePage objHomePage =new HomePage();
		AdminPage objAdminPage=new AdminPage();
		UserPage objUserPage=new UserPage();
		DashboardFunctions objDashBoardFunctions=new DashboardFunctions();
		MembershipAdminPage objMembershipAdminPage=new MembershipAdminPage();
		MyProfilePage objMyProfilePage=new MyProfilePage();
		//Calling the functions
		objLoginPage.launchURL(driver,url);
		objLoginPage.login(driver, strAdminUserName, strAdminPassword);
		objHomePage.NavigateToAdmin(driver);
		objAdminPage.SelectUserAdmin(driver);
		objUserPage.AddUser(driver, strUserName, strEmailAddress, strFirstName, strLastName, strPassword, strTimeZone, strLocale, strMemberStatus, strSystemRole, strJobRole,genderType);
		objMembershipAdminPage.MapToCenterMembership(driver, strcentersubType, strcenterSrc);
		objAdminPage.returnToHome(driver);
		objDashBoardFunctions.logOff(driver);
		objLoginPage.login(driver, strUserName, strPassword);
		//objLoginPage.acceptAgreement(driver);
		objLoginPage.passwordReset(driver,strPassword,strnewPassword);	
		objDashBoardFunctions.selectMyProfile(driver);
		objMyProfilePage.verifyUser(driver, strUserName);
	}
}
