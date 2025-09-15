package Test.salesforce;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MergeAccount;
import pageObjects.Opportunities;
import pageObjects.TopMenuPanel;
import utils.CommonUtils;

public class FunctionsTest extends BaseTest {

		// creating object
	@Test(groups = { "smoke", "regression", "functions" })
	public void t13_merge() {
		LoginPage login = new LoginPage(driver);
		MergeAccount mergeaccount = new MergeAccount(driver);
		TopMenuPanel homepage = new TopMenuPanel(driver);

		// Test Case methods
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homepage.selectTopPanelMenu("Accounts");
		mergeaccount.mergeAccounts("Test", Arrays.asList("Test User2", "Test User1"));

	}

	@Test(groups = { "regression", "functions" })

	public void tc_14_accoutvalidation(String[] args) {
		
		// create object
		
		// Testcase methods
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Accounts");
		accountspage.clickAccwithLastActivity();
		accwithlastactivity.validatePage();
		accountspage.filterByDate();
	}

	@Test(groups = { "regression", "functions" })
	public void tc_15_Opportunities(String[] args) {
		
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Opportunities");
		opportunities.OpportunitiesTabClick();

	}

	@Test(groups = { "regression", "functions" })
	public void tc_16_AddOpportunities() {
		
		// create object
		LoginPage login = new LoginPage(driver);
		TopMenuPanel homepage = new TopMenuPanel(driver);
		Opportunities opportunities = new Opportunities(driver);
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homepage.selectTopPanelMenu("Opportunities");
		// opportunities.OpportunitiesTabClick();
		opportunities.newOpportunities("Test Role", "ABC", "Test User");
	}
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		CommonUtils.sleepThread(10);
		driver.quit();
	}

}
