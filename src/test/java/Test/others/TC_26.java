package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.ContactMenu;
import pageObjects.TopMenuPanel;
import pageObjects.LoginPage;

public class TC_26 {

	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Page objects
		LoginPage login = new LoginPage(driver);
		TopMenuPanel homepage = new TopMenuPanel(driver);
		ContactMenu contactmenu=new ContactMenu(driver);

		// Test Steps
		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homepage.selectTopPanelMenu("Contacts");
		String viewName = "User"+System.currentTimeMillis();
		contactmenu.clickCreatenewview(viewName, viewName);
		if (viewName.equals(contactmenu.contactSelectValidation())){
			System.out.println(viewName+" view visible");
		} else {
			System.out.println(viewName+" view not visible");
		}
	}

}
