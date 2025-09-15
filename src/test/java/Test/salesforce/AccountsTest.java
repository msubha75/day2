package Test.salesforce;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class AccountsTest extends BaseTest {

	
	@Test(groups = { "smoke","regression","accounts" })
	public void tc10_create_account() {
		// Test Steps
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectCreateMenu("Account");
		createAccountPage.createAccount("Test User", "Technology Partner", "High");
		// validate account details --> step to be added
	}

	@Test(groups = { "smoke", "regression","accounts" })
	public void tc11_create_validate_view() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Account");
		accountsPage.createAndSaveNewView("Test View-2", "testview02");
		topMenuPanel.selectTopPanelMenu("Account");
		accountsPage.validateSelectedView("Test View-2");
	}

	@Test(groups = { "regression","accounts" })
	public void tc12_edit_view() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Account");
		accountsPage.selectView("Test View-1");
		accountsPage.validateSelectedView("Test View-1");
		accountsPage.editView("Testview3", "a");
	}
	@Test(groups= {"regression","accounts"})
	public void tc13_mergeAccount()
	{
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	topMenuPanel.selectTopPanelMenu("Accounts");
	mergeAccount.mergeAccounts("Test", Arrays.asList("Test User2", "Test User1"));
	}
	@Test(groups= {"regression","account"})
	public void tc14_AccwithLastActivity()
	{
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	topMenuPanel.selectTopPanelMenu("Accounts");
	accountspage.clickAccwithLastActivity();
	accwithlastactivity.validatePage();
	accountspage.filterByDate();
	}
	
	

}
