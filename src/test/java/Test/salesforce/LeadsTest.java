package Test.salesforce;

import org.testng.annotations.Test;

public class LeadsTest extends BaseTest {
	@Test(groups = { "Regression", "Leads" })
	public void TC_20_leadTab() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Leads");
		leadsPage.LeadTab();
	}
	@Test(groups= {"Regression","Leads"})
	public void TC_21_displayAllOption()
	{
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	topMenuPanel.selectTopPanelMenu("Leads");
	leadsPage.displayAlOptions();
}
	@Test(groups= {"Regression","Leads"})
	public void TC_22_validateTodayPage()
	{
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	topMenuPanel.selectTopPanelMenu("Leads");
	leadsPage.LeadTab();
	leadsPage.selectViewFromList("Today's Leads");
	topMenuPanel.selectUserMenu("Logout");
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	leadsPage.LeadTab();
	leadsPage.selectViewFromList("Today's Leads");
	leadsPage.getFirstSelectedOption();
	leadsPage.GoButton();
	leadsPage.validateTodayPage();
}
	@Test(groups= {"Regression","Leads"})
	public void TC_23_selectTopPanelMenu()
	{
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	topMenuPanel.selectTopPanelMenu("Leads");
	leadsPage.LeadTab();
	leadsPage.selectViewFromList("Today's Leads");
	leadsPage.GoButton();
	leadsPage.validateTodayPage();
	}
	@Test(groups= {"Regression","Leads"})
	public void TC_24_createLead()
	{
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	topMenuPanel.selectTopPanelMenu("Leads");
	leadsPage.createLead();
	leadsPage.leadInfo("ABCD", "ABCD");
	}


	
}
