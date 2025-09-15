package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.AllTabs;
import pageObjects.LoginPage;
import pageObjects.TopMenuPanel;

public class TC_35 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Page objects
		LoginPage login = new LoginPage(driver);
		TopMenuPanel topmenupanel = new TopMenuPanel(driver);
		AllTabs alltabs = new AllTabs(driver);
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topmenupanel.selectTopPanelMenu("AllTabs");
		alltabs.customizeMytabclick();
		alltabs.removeTab("Chatter");
		alltabs.saveBtn();
		topmenupanel.selectUserMenu("Logout");
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		alltabs.validatePage("chatter Tab");
		topmenupanel.selectTopPanelMenu("AllTabs");

		alltabs.customizeMytabclick();
		alltabs.addtab("Chatter");
		alltabs.saveBtn();
		// topmenupanel.selectTopPanelMenu("ChatterTab");

	}

}
