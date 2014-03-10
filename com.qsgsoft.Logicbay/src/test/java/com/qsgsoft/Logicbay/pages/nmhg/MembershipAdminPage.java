package com.qsgsoft.Logicbay.pages.nmhg;

import org.openqa.selenium.WebDriver;

public class MembershipAdminPage extends com.qsgsoft.Logicbay.pages.core.MembershipAdminPage{

	public MembershipAdminPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}
	
	public void NmhgUserMapping(String strcentersubType, String strcenterSrc)
			throws Exception {
		this.selectcenterMembership(strcentersubType,
				strcenterSrc);
		selectSubmitOnMapping();
		selectReturnOnMapping();
	}
}