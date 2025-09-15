package Test.others;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.*;


public class SalesForce {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Declare Page Objects
		LoginPage loginPage = new LoginPage(driver);
		TopMenuPanel homePage = new TopMenuPanel(driver);
		MyProfile myProfile = new MyProfile(driver);
		EditPanel editPanel = new EditPanel(driver);
		PostPanel postpanel=new PostPanel(driver);
		
		// Test Steps
		driver.get("https://login.salesforce.com/");
		loginPage.loginSF("msubha75762@agentforce.com", "Tiru@1994");
		homePage.selectUserMenu("My Profile");
		myProfile.editContact();
		editPanel.selectAboutTab();
		
		editPanel.setLastName("Meenakshi sundaram");
		editPanel.SaveBtn();
		postpanel.postLink();
		postpanel.postInfo("Hello");
		postpanel.shareBtn();
		homePage.selectUserMenu("LogOut");
	}
}
		