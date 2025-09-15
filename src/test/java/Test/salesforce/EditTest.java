package Test.salesforce;

import org.testng.annotations.Test;

public class EditTest extends BaseTest{
	@Test(groups= {"Regression","Edit"})
	public void Tc_34_editPanel()
	{
	
	loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
	topMenuPanel.selectTopPanelMenu("Home");
	homePage.clickUserName();
	editPanel.editProfileicon();
	editPanel.verifyContactTabSelected();
	editPanel.selectAboutTab();
	editPanel.setLastName("Abcd");
	editPanel.SaveBtn();
	String updatedmenuname = editPanel.usrnamechangeValidation();
	System.out.println("Updated menu name is:" + updatedmenuname);

	String updatedname = editPanel.usrnamechangeValidation();
	System.out.println("Updated name is:" + updatedname);
}
}