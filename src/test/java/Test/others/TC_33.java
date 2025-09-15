package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.TopMenuPanel;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyProfile;

public class TC_33 {


	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Page objects
		LoginPage login = new LoginPage(driver);
		TopMenuPanel topMenuPanel = new TopMenuPanel(driver);
		HomePage homePage = new HomePage(driver);
		MyProfile myprofile=new MyProfile(driver);
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topMenuPanel.selectTopPanelMenu("Home");
		homePage.clickUserName();
		myprofile.validatePage();
		String currentURL1 = driver.getCurrentUrl();
		// Navigate to My profile from accounts
		topMenuPanel.selectUserMenu("My Profile");
		myprofile.validatePage();
		String currentURL2 = driver.getCurrentUrl();
		if(currentURL1.equals(currentURL2)) {
			System.out.println("Both URLs are same");
		} else {
			System.out.println("Both URLs are not same");
		}
		
		
		// if()
		// 	homePage.validatePage();

	}

}
