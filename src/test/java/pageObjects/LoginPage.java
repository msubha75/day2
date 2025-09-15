package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;

	// Constructors

	public LoginPage(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Locators



	@FindBy(xpath = "//*[@id='username']")
	WebElement usernameBox;

	@FindBy(xpath = "//*[@id='password']")
	WebElement passwordBox;

	@FindBy(xpath = "//*[@id='Login']")
	WebElement loginBtn;

	// Action Methods

	public void loginSF(String username, String password) {
		wait.until(ExpectedConditions.visibilityOf(usernameBox));
		usernameBox.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(passwordBox));
		passwordBox.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();

	}
}
