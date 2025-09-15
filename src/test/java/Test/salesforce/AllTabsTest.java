package Test.salesforce;

import org.testng.annotations.Test;

public class AllTabsTest extends BaseTest {
	@Test(groups = { "Regression", "alltabs1" })
	public void Tc_36_customizemyTab() {
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("AllTabs");
		alltabs.customizeMytabclick();
		alltabs.removeTab("Chatter");
		alltabs.saveBtn	();
		topMenuPanel.selectUserMenu("Logout");
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		alltabs.validatePage("chatter Tab");
		topMenuPanel.selectTopPanelMenu("AllTabs");

		alltabs.customizeMytabclick();
		alltabs.addtab("Chatter");
		alltabs.saveBtn();
	}
}