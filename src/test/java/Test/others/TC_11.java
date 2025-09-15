package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.*;
import utils.CommonUtils;

public class TC_11 {

	public static void main(String[] args) {

		// Chromedriver initialization
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Page Objects
		LoginPage loginPage = new LoginPage(driver);
		TopMenuPanel homePage = new TopMenuPanel(driver);
		AccountsPage accountsPage = new AccountsPage(driver);

		// Test StepshomePage.selectAccountTab("Account");
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homePage.selectTopPanelMenu("Account");
		accountsPage.createAndSaveNewView("Test View-2", "testview02");
		homePage.selectTopPanelMenu("Account");
		accountsPage.validateSelectedView("Test View-2");
		
		CommonUtils.sleepThread(10);
		driver.quit();
	}

}
