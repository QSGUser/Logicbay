package com.qsgsoft.Logicbay.requirement.Daimler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.qsgsoft.Logicbay.modules.DashboardFunctions;
import com.qsgsoft.Logicbay.pages.Core.AdminPage;
import com.qsgsoft.Logicbay.pages.Core.HomePage;
import com.qsgsoft.Logicbay.pages.Core.LoginPage;
import com.qsgsoft.Logicbay.pages.Core.MembershipAdminPage;
import com.qsgsoft.Logicbay.pages.Core.UserPage;
import com.qsgsoft.Logicbay.pages.Daimler.DaimlerHomePage;
import com.qsgsoft.Logicbay.pages.Daimler.DaimlerLoginPage;
import com.qsgsoft.Logicbay.pages.Daimler.DaimlerUserPage;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;
public class Add_EditUserDaimler extends Configuration{
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
	public void AddUserToDaimlerServer() throws Exception{	
		gstrTO="Verify that a user can be added in Performance Center";
		gstrTCID="132534";
		url="http://lbapp10.logicbay.com/daimler_preprod/login/login.jsp";
		strAdminUserName = objTestData.strDaimlerLoginName;
		strAdminPassword = objTestData.strDaimlerPassword;
		//Data for creating a user
		String strUserName=objTestData.strDaimlerUserName;
		String strEmailAddress=objTestData.strEmailAddress;
		String strFirstName=objTestData.strFirstName;
		String strMiddleName=objTestData.strMiddleName;
		String strLastName=objTestData.strLastName;
		String strPassword=objTestData.strPassword;
		String strTechnicalId=objTestData.strTecnicalId;
		String strTimeZone=objTestData.strTimezone;
		String strLocale=objTestData.strLocale;
		String strMemberStatus=objTestData.strMemberstatus;
		String strSystemRole=objTestData.strSystemrole;
		String strJobRole=objTestData.strDaimlerJobRole;
		String strAssociatedAccount=objTestData.strDaimlerAccount;
		String strcentersubType=objTestData.strcenterSubtype;
		String strcenterSrc=objTestData.strcenterSrcDaimler;
		String strnewPassword=objTestData.strnewPassword;;
		//Creating the objects
		LoginPage objLoginPage=new LoginPage();
		DaimlerLoginPage objDaimlerLoginPage=new DaimlerLoginPage();
		DaimlerHomePage objDaimlerHomePage=new DaimlerHomePage();
		DaimlerUserPage objDaimlerUserPage=new DaimlerUserPage();
		AdminPage objAdminPage=new AdminPage();
		DashboardFunctions objDashBoardFunctions=new DashboardFunctions();
		MembershipAdminPage objMembershipAdminPage=new MembershipAdminPage();
		//Calling the functions
		objLoginPage.launchURL(driver,url);
		objDaimlerLoginPage.loginToDaimler(driver, strAdminUserName, strAdminPassword);
		objDaimlerHomePage.NavigateToAdmin(driver);
		objAdminPage.SelectUserAdmin(driver);
		objDaimlerUserPage.DaimlerUserCreation(driver,strUserName,strEmailAddress,strFirstName,strMiddleName,strLastName,strPassword,strTechnicalId,strTimeZone,strLocale,strMemberStatus,strSystemRole,strJobRole,strAssociatedAccount);
		objMembershipAdminPage.MapToCenterMembership(driver,strcentersubType,strcenterSrc);
		objAdminPage.returnToHome(driver);	
		objDashBoardFunctions.logOff(driver);
		objDaimlerLoginPage.switchToWindow(driver);
		objLoginPage.enterUsername(driver, strEmailAddress);
		objDaimlerLoginPage.enterNewPassword(driver, strPassword);
		
	}
}
