package Test.salesforce;

import org.testng.annotations.Test;

public class OpportunitiesTest extends BaseTest {

@Test(groups={"Regression","Opportunities"})
	public void TC_15_opportunitiesTab()
	{
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Opportunities");
		opportunities.OpportunitiesTabClick();
	}
@Test(groups= {"Regression","Opportunities"})
public void TC_16_Asssignvalues()
{
loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
topMenuPanel.selectTopPanelMenu("Opportunities");
opportunities.newOpportunities("Test Role", "ABC", "Test User");
}
@Test(groups= {"Regression","Opportunities"})
public void TC_17_Validatepipeline()
{
loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
topMenuPanel.selectTopPanelMenu("Opportunities");
opportunities.validatePipeline();
}
@Test(groups= {"Regression","Opportunities"})
public void TC_18_validateStuckOpportunities()
{
loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
topMenuPanel.selectTopPanelMenu("Opportunities");

opportunities.validateStuckOpportunities();
}
@Test(groups= {"Regression", "Opportunities"})
public void TC_19_runReport()
{
loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
topMenuPanel.selectTopPanelMenu("Opportunities");
opportunities.runReport("Next FQ", "Open Opportunities");
}
}