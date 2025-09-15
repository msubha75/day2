package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.*;

public class TC_10 {

	public static void main(String[] args) {
		
		// Chromedriver initialization
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Page Objects
		LoginPage loginPage = new LoginPage(driver);
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		TopMenuPanel topMenuPanel = new TopMenuPanel(driver);

		// Test Steps
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectCreateMenu("Account");
		createAccountPage.createAccount("Test User", "Technology Partner", "High");
		// validate account details --> step to be added	
	}

}
