package Test.salesforce;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
	@Test(groups={"Regression","homePage"})
	public void Tc_37_homePage()
	{
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");

		topMenuPanel.selectTopPanelMenu("Home");
		homePage.clickCurrentDateLink();
		homePage.selecttimelink();
		homePage.selectSubject("Other");
		homePage.selectTime("5:00 PM", "7:00 PM");
	/*
	 * Robot robot = new Robot(); for (int i = 0; i < 20; i++) {
	 * robot.mouseWheel(15); Thread.sleep(100); }
	 */
		homePage.checkCreateRecurringEvents();
		homePage.selectFrquency("Weekly", "1", "Thursday");

	String startDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	String endDate = LocalDate.now().plusDays(14).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	homePage.selectdate(startDate, endDate);
	homePage.save();
}
}
