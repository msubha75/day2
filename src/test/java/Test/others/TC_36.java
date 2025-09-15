package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TopMenuPanel;

public class TC_36 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Page objects
		LoginPage login = new LoginPage(driver);
		TopMenuPanel topmenupanel = new TopMenuPanel(driver);
		HomePage homepage = new HomePage(driver);
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");

		topmenupanel.selectTopPanelMenu("Home");
		homepage.clickCurrentDateLink();
		homepage.clicktime();
		homepage.selectSubject("Other");
		homepage.selectTime("11:30 PM", "9:00 PM");
		homepage.clickSave();
	}
}
