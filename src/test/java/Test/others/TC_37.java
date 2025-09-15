package Test.others;

import java.awt.AWTException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TopMenuPanel;

public class TC_37 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Page objects
		LoginPage login = new LoginPage(driver);
		TopMenuPanel topmenupanel = new TopMenuPanel(driver);
		HomePage homepage = new HomePage(driver);
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");

		topmenupanel.selectTopPanelMenu("Home");
		homepage.clickCurrentDateLink();
		homepage.selecttimelink();
		homepage.selectSubject("Other");
		homepage.selectTime("5:00 PM", "7:00 PM");
		/*
		 * Robot robot = new Robot(); for (int i = 0; i < 20; i++) {
		 * robot.mouseWheel(15); Thread.sleep(100); }
		 */
		homepage.checkCreateRecurringEvents();
		homepage.selectFrquency("Weekly", "1", "Thursday");
	
		String startDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		String endDate = LocalDate.now().plusDays(14).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		homepage.selectdate(startDate, endDate);
		homepage.save();
	}

}
