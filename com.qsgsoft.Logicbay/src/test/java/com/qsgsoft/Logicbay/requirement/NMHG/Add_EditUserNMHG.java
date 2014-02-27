package com.qsgsoft.Logicbay.requirement.NMHG;
import com.qsgsoft.Logicbay.modules.DashboardFunctions;
import com.qsgsoft.Logicbay.pages.Core.AdminPage;
import com.qsgsoft.Logicbay.pages.Core.LoginPage;
import com.qsgsoft.Logicbay.pages.NMHG.NmhgHomePage;
import com.qsgsoft.Logicbay.pages.NMHG.NmhgUserPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.qsgsoft.Logicbay.support.Configuration;
import com.qsgsoft.Logicbay.support.TestData;

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
		String strcentersubType=objTestData.strcenterSubtype;
		String strcenterSrc=objTestData.strcenterSrcNMHG;	
		String strnewPassword=objTestData.strnewPassword;
		//Creating objects
		LoginPage objLoginPage = new LoginPage();
		NmhgHomePage objNmhgHomePage =new NmhgHomePage();
		AdminPage objAdminPage=new AdminPage();
		NmhgUserPage objNmhgUserPage=new NmhgUserPage();
		DashboardFunctions objDashBoardFunctions=new DashboardFunctions();
		//Calling the functions
		objLoginPage.launchURL(driver,url);
		objLoginPage.login(driver, strAdminUserName, strAdminPassword);
		objNmhgHomePage.NavigateToAdmin(driver);
		objAdminPage.SelectUserAdmin(driver);
		objNmhgUserPage.NmhgUserCreation(driver,strEmailAddress,strFirstName,strLastName,strPassword,strTimeZone,strLocale,strMemberStatus,strSystemRole,strJobRole,strJobTitle);
		objNmhgUserPage.NmhgUserMapping(driver,strcentersubType,strcenterSrc);
		objAdminPage.returnToHome(driver);	
		objDashBoardFunctions.logOff(driver);
		objLoginPage.login(driver, strEmailAddress, strPassword);
		objLoginPage.acceptAgreement(driver);
		objLoginPage.passwordReset(driver,strPassword,strnewPassword);	
	}	
}