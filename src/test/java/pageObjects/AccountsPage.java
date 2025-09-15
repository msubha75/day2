package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.CommonUtils;

public class AccountsPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(xpath = "//li[@id='Account_Tab']")
	WebElement accountBtn;

	@FindBy(xpath = "//*[text()='Create New View']")
	WebElement createNewView;

	@FindBy(xpath = "//input[@id='fname']")
	WebElement nameField;

	@FindBy(xpath = "//input[@id='devname']")
	WebElement uniqueNameField;

	@FindBy(xpath = "(//input[@title='Save'])[1]")
	WebElement saveBtn;

	@FindBy(xpath = "//*[@title='View:']")
	WebElement viewList;
	@FindBy(xpath = "//*[@id='filter_element']/div/span/span[2]/a[1]")
	WebElement EditBtn;
	@FindBy(xpath = "//input[@id='fname']")
	WebElement ViewNameBox;
	@FindBy(xpath = "//select[@id='fcol1']")
	WebElement FieldTab;
	@FindBy(xpath = "//select[@id='fop1']")
	WebElement OperatorTab;
	@FindBy(xpath = "//select[@id='fop1']")
	WebElement ValueTab;
	@FindBy(xpath = "//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]")
	WebElement SaveBtn;
	@FindBy(xpath = "//a[normalize-space()='Accounts with last activity > 30 days']")
	WebElement cickLastActivity; 
	@FindBy(xpath = "//*[@id='ext-gen20']")
	WebElement DateField;
	@FindBy(xpath = "//*[@id='ext-gen293']/div[3]")
	WebElement CreatedDate;

	@FindBy(xpath = "//li[@id='x-menu-el-ext-comp-1044']")
	WebElement Calendar;
	@FindBy(xpath = "//img[@id='ext-gen153']")
	WebElement FromDate;
	@FindBy(xpath = "//img[@id='ext-gen155']")
	WebElement EndDate;
	@FindBy(xpath = "//button[@id='ext-gen312']")
	WebElement MonthYear;
	@FindBy(xpath = "(//span[contains(text(),'29')])[2]")
	WebElement Today;

	public void createAndSaveNewView(String viewName, String uniqueName) {
		wait.until(ExpectedConditions.elementToBeClickable(createNewView));
		createNewView.click();
		wait.until(ExpectedConditions.visibilityOf(nameField));
		nameField.sendKeys(viewName);
		wait.until(ExpectedConditions.visibilityOf(uniqueNameField));
		uniqueNameField.clear();
		uniqueNameField.sendKeys(uniqueName);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	}

	public void selectView(String viewName) {
		wait.until(ExpectedConditions.visibilityOf(viewList));
		Select select = new Select(viewList);
		select.selectByContainsVisibleText(viewName);
	}

	public void validateSelectedView(String viewName) {
		wait.until(ExpectedConditions.visibilityOf(viewList));
		Select select = new Select(viewList);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), viewName);
		/*
		 * if (viewName.equals(select.getFirstSelectedOption().getText())) {
		 * System.out.println("View w visible and validated"); } else {
		 * Assert.assertTrue(false); }
		 */
	}

	public void editView(String viewName, String accountName) {
		wait.until(ExpectedConditions.visibilityOf(EditBtn));
		EditBtn.click();
		wait.until(ExpectedConditions.visibilityOf(ViewNameBox));
		ViewNameBox.sendKeys(viewName);
		CommonUtils.selectValues(FieldTab, "Account Name");
		CommonUtils.selectValues(OperatorTab, "contains");
		ValueTab.sendKeys(accountName);
		SaveBtn.click();
	}

	public void clickAccwithLastActivity() {
		cickLastActivity.click();
	}

	public void filterByDate() {
		wait.until(ExpectedConditions.elementToBeClickable(DateField));
		DateField.click();
		wait.until(ExpectedConditions.elementToBeClickable(CreatedDate));
		CreatedDate.click();

		FromDate.click();
		wait.until(ExpectedConditions.visibilityOf(Calendar));
		String MonthandYear = MonthYear.getText();
		Today.click();

	}

}