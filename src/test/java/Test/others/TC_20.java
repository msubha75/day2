package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.TopMenuPanel;
import pageObjects.LeadsPage;
import pageObjects.LoginPage;

public class TC_20 {


	public static void main(String[] args) {
		// Driver Initialization 
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				WebDriver driver = new ChromeDriver(options);
				driver.get("https://login.salesforce.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				// Page objects
				LoginPage login = new LoginPage(driver);
				TopMenuPanel homepage = new TopMenuPanel(driver);
				LeadsPage leadspage=new LeadsPage(driver);
				
				
				
				// Test Steps
				login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
				homepage.selectTopPanelMenu("Leads");
				leadspage.LeadTab();
	}

}
