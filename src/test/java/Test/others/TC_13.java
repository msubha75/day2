package Test.others;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.TopMenuPanel;
import pageObjects.LoginPage;
import pageObjects.MergeAccount;

public class TC_13 {

	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// creating object
		LoginPage login = new LoginPage(driver);
		MergeAccount mergeaccount=new MergeAccount(driver);
		TopMenuPanel homepage = new TopMenuPanel(driver);

		//Test Case methods
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homepage.selectTopPanelMenu("Accounts");
		mergeaccount.mergeAccounts("Test", Arrays.asList("Test User2", "Test User1"));

	}

}
