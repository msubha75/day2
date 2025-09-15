package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.AccountsPage;
import pageObjects.AccwithLastActivity;
import pageObjects.TopMenuPanel;
import pageObjects.LoginPage;

public class TC_14 {

	

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//create object
		LoginPage login = new LoginPage(driver);
		TopMenuPanel homepage=new TopMenuPanel(driver);
		AccountsPage accountspage=new AccountsPage(driver);
		AccwithLastActivity accwithlastactivity=new AccwithLastActivity(driver);
	
		//Testcase methods
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homepage.selectTopPanelMenu("Accounts");
		accountspage.clickAccwithLastActivity();
		accwithlastactivity.validatePage();
		accountspage.filterByDate();
	}

}
