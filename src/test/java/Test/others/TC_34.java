package Test.others;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.EditPanel;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TopMenuPanel;

public class TC_34 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Page objects
		LoginPage login = new LoginPage(driver);
		TopMenuPanel topmenupanel = new TopMenuPanel(driver);
		HomePage homepage = new HomePage(driver);
		EditPanel editpanel = new EditPanel(driver);

		login.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		topmenupanel.selectTopPanelMenu("Home");
		homepage.clickUserName();
		editpanel.editProfileicon();
		editpanel.verifyContactTabSelected();
		editpanel.selectAboutTab();
		editpanel.setLastName("Abcd");
		editpanel.SaveBtn();
		String updatedmenuname = editpanel.usrnamechangeValidation();
		System.out.println("Updated menu name is:" + updatedmenuname);

		String updatedname = editpanel.usrnamechangeValidation();
		System.out.println("Updated name is:" + updatedname);

	}

}
