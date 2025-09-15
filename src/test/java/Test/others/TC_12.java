package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.*;

public class TC_12 {

	public static void main(String[] args) {

		// chromedriver initialization
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// creating object
		LoginPage login = new LoginPage(driver);
		TopMenuPanel homepage = new TopMenuPanel(driver);
		AccountsPage accountsPage = new AccountsPage(driver);


		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homepage.selectTopPanelMenu("Account");
		accountsPage.selectView("Test View-1");
		accountsPage.validateSelectedView("Test View-1");
		accountsPage.editView("Testview3", "a");
	}

}
