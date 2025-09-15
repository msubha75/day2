package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeAccount {
	WebDriver driver;
	WebDriverWait wait;

	public MergeAccount(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Accounts']")
	WebElement accountTab;
	
	@FindBy(xpath = "//a[normalize-space()='Merge Accounts']")
	WebElement mergeAccLink;
	
	@FindBy(xpath = "//input[@id='srch']")
	WebElement findAccountTextbox;
	
	@FindBy(xpath = "//div[@class='pbWizardBody']//input[2]")
	WebElement findBtn;
	
	@FindBy(xpath = "//input[@id='cid0']")
	WebElement checkBox1;
	
	@FindBy(xpath = "//input[@id='cid1']")
	WebElement checkBox2;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Merge']")
	WebElement mergeBtn;
	
	@FindBy(xpath = "//input[@id='p2001gL00000FLerW']")
	WebElement radioBtn1;
	
	@FindBy(xpath = "//input[@id='p2001gL00000FMlan']")
	WebElement radioBtn2;
	
	@FindBy(xpath = "//*[contains(@class,'dataRow')]")
	List<WebElement> dataRows;


	public void mergeAccounts(String searchTerm, List<String> accounts) {
		wait.until(ExpectedConditions.elementToBeClickable(mergeAccLink));
		mergeAccLink.click();
		wait.until(ExpectedConditions.visibilityOf(findAccountTextbox));
		findAccountTextbox.sendKeys(searchTerm);
		findBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(dataRows));
		for (WebElement dataRow: dataRows) {
			WebElement nameRow = dataRow.findElement(By.xpath(".//td[2]"));
			System.out.println(nameRow.getText());
			if(accounts.contains(nameRow.getText())) {
				WebElement checkBoxRow = dataRow.findElement(By.xpath("./th/input"));
				if(!checkBoxRow.isSelected()) {
					checkBoxRow.click();
				}		
			}
		}
		wait.until(ExpectedConditions.visibilityOf(nextBtn));
		nextBtn.click();
		wait.until(ExpectedConditions.visibilityOf(mergeBtn));
		mergeBtn.click();
		driver.switchTo().alert().accept();
	}
	
}
