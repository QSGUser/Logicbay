package pages.core;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import lib.WebElements;

public class MembershipPage extends WebElements {
	private String centerMembership = "//div[@id='tab_data_6']/table/tbody/tr[2]/td[1]",
			getItems = "//input[@name='btnGetItems']",
			selectSrc = "//select[@class='cListField'][@name='srcList']",
			checkTarget = "//form/table[3]/tbody/tr[2]/td[3]/select[@name='trgtList']",
			moveRight = "//input[@id='move_right']",
			selectSubmit = "//input[@type='button'][@value='Submit']",
			allowInheritance = "//input[@id='setAsInheritable'][@class='cInheritButton']",
			selectReturn = "//td[@class='cListControlPanel']/a",
			organizationMemebership = "//div[@id='tab_data_6']/table/tbody/tr[4]/td[1]",
			administeredMembership = "//div[@id='tab_data_6']/table/tbody/tr[10]/td[1]",
			keywordField = "keyword", selectsubType = "srctype";
	public WebDriver driver;
	WebElement element;

	public MembershipPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	public MembershipPage selectcenterMembership() throws Exception {
		element = getElement(centerMembership, "xpath");
		element.click();
		handleAlert();
		return this;
	}

	public MembershipPage verifyTarget() throws Exception {
		assertTrue(isElementPresent(By.xpath(checkTarget)));
		return this;
	}

	public MembershipPage selectgetItems() throws Exception {
		element = getElement(getItems, "xpath");
		element.click();
		return this;
	}

	public MembershipPage selectSubmitOnMapping() throws Exception {
		Actions action = new Actions(driver);
		element = getElement(selectSubmit, "xpath");
		element.click();
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public MembershipPage selectReturnOnMapping() throws Exception {
		Actions action = new Actions(driver);
		element = getElement(selectReturn, "xpath");
		action.moveToElement(element).click().build().perform();
		return this;
	}

	public MembershipPage selectsrcToMap(String src) throws Exception {
		assertTrue(isElementPresent(By.xpath(selectSrc)));
		element = getElement(selectSrc, "xpath");
		new Select(element).selectByVisibleText(src);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(src));
		return this;
	}

	public MembershipPage selectMap() throws Exception {
		
		element = getElement(moveRight, "xpath");
		element.click();
		return this;
	}

	public MembershipPage selectorganizationMemebership(String subType,
			String src, String key) throws Exception {
		
		element = getElement(organizationMemebership, "xpath");
		element.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public MembershipPage enterKeyword(String key) throws Exception {
		element = getElement(keywordField, "name");
		element.clear();
		element.sendKeys(key);
		assertEquals(key, element.getAttribute("value"));
		return this;
	}

	public MembershipPage selectsubType(String subType) throws Exception {
		assertTrue(isElementPresent(By.id(selectsubType)));
		element = getElement(selectsubType, "id");
		new Select(element).selectByVisibleText(subType);
		String SelectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(SelectedVal.equals(subType));
		return this;
	}

	public MembershipPage selectAllowInheritance() throws Exception {
		Actions action = new Actions(driver);
		element = getElement(allowInheritance, "xpath");
		action.moveToElement(element)
				.click().build().perform();
		return this;
	}

	public MembershipPage administeredMembership() throws Exception {
		element = getElement(administeredMembership, "xpath");
		element.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public MembershipPage MapToadministeredMembership(String subType,
			String src, String key) throws Exception {
		administeredMembership();
		selectsubType(subType);
		enterKeyword(key);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
		selectAllowInheritance();
		selectSubmitOnMapping();
		selectReturnOnMapping();
		return this;
	}

	public MembershipPage MapToCenterMembership(String subType, String src)
			throws Exception {
		selectcenterMembership();
		selectsubType(subType);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
		selectSubmitOnMapping();
		selectReturnOnMapping();
		return this;
	}

	public MembershipPage MapToOrgMembership(String subType, String src,
			String key) throws Exception {
		selectorganizationMemebership(subType, src, key);
		selectsubType(subType);
		enterKeyword(key);
		selectgetItems();
		selectsrcToMap(src);
		selectMap();
		verifyTarget();
		selectSubmitOnMapping();
		selectReturnOnMapping();
		return this;
	}
}