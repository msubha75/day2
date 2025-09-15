package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

	WebDriver driver;
	WebDriverWait wait;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='detailList']//*[@name='acc2']")
	WebElement accountNameBox;
	
	@FindBy(xpath = "//*[@class='detailList']//*[@name='acc6']")
	WebElement accountTypeBox;
	
	@FindBy(xpath = "//*[@class='detailList']//*[@tabindex='28']")
	WebElement accountPriortyBox;
	
	@FindBy(xpath = "//td[@class='pbButtonb']//input[@title='Save']")
	WebElement Save;
	
	
	// Test Methods

	public void createAccount(String accountName, String accountType, String priorty) {
		wait.until(ExpectedConditions.visibilityOf(accountNameBox));
		accountNameBox.sendKeys(accountName);
		wait.until(ExpectedConditions.visibilityOf(accountTypeBox));
		Select select1 = new Select(accountTypeBox);
		select1.selectByContainsVisibleText(accountType);
		wait.until(ExpectedConditions.elementToBeClickable(accountPriortyBox));
		Select select2 = new Select(accountTypeBox);
		select2.selectByContainsVisibleText(priorty);
		wait.until(ExpectedConditions.visibilityOf(Save));
		Save.click();
	}	
}