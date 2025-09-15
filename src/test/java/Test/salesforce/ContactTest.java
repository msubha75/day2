package Test.salesforce;

import org.testng.Assert;

import org.testng.annotations.Test;
public class ContactTest extends BaseTest {
	
	@Test(groups = { "Regression", "smoke" })
	public void TC_25_contactMenu() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");
		contactMenu.clickElement("newBtn");
		contactMenu.sendText("lastNameBox", "Sundaram");
		contactMenu.Accname("Test User");
	}

	@Test(groups = { "Regression", "Contact" })
	public void TC_26_validateViewName() {

		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");
		String viewName = "User" + System.currentTimeMillis();
		contactMenu.clickCreatenewview(viewName, viewName);
		
		Assert.assertEquals(contactMenu.contactSelectValidation(), viewName, "View is not visible");
		System.out.println(viewName + " view visible");
	}

	@Test(groups = { "Regression", "Contact" })
	public void Tc_27_selectOption() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");
		contactMenu.clickdropdown();

		String selectedOption = contactMenu.getFirstOption();
		System.out.println("Selected Option is:" + selectedOption);
		contactMenu.clickElement("GoBtn");
	}

	@Test(groups = { "Regression", "Contact" })
	public void Tc_28_selectViewOption() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");
		contactMenu.clickViewDropdown();
		contactMenu.clickElement("GoBtn");
		String selectedviewoption = contactMenu.getOption();
		System.out.println("selectedviewoption is: " + selectedviewoption);
	}

	@Test(groups = { "Regression", "Contact" })
	public void Tc_29_selectUser() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");
		// contactmenu.clickViewDropdown();
		// contactmenu.clickGoBtn();
		contactMenu.selectuser("Test7, user7");
		contactMenu.userselectvalidation();
	}

	@Test(groups = { "Regression", "Contact" })
	public void Tc_30_clickCreateNewView() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");
		contactMenu.clickCreatenewview("EFGH");
		contactMenu.printErrorMsg();
	}

	@Test(groups = { "Regression", "Contact" })
	public void Tc_31_validateContactHomePage() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");
		contactMenu.createnewviewpage("ABCD", "EFGH");
		contactMenu.contacthomepagevalidation();
	}

	@Test(groups = { "Regression", "Contact" })
	public void Tc_32_validateContact() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Contacts");

		contactMenu.clickElement("newBtn");
		// contactmenu.btnClick();
		contactMenu.sendText("lastNameBox", "Indian");
		contactMenu.Accname("Global Media");
		contactMenu.cicksaveandnewbtn();
		contactMenu.validatecontact();
		contactMenu.pagevalidation();

	}

	@Test(groups = { "Regression", "Contact" })
	public void Tc_33_validateURL() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Home");
		homePage.clickUserName();
		myprofile.validatePage();
		String currentURL1 = driver.getCurrentUrl();
		// Navigate to My profile from accounts
		topMenuPanel.selectUserMenu("My Profile");
		myprofile.validatePage();
		String currentURL2 = driver.getCurrentUrl();
		if (currentURL1.equals(currentURL2)) {
			System.out.println("Both URLs are same");
		} else {
			System.out.println("Both URLs are not same");
		}
	}
}