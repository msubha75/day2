package pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.CommonUtils;

public class LeadsPage {
	WebDriver driver;
	WebDriverWait wait;
	private static final Logger log = Logger.getLogger(LeadsPage.class);

	public LeadsPage(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='Lead_Tab']/a")
	WebElement leadTab;

	@FindBy(xpath = "//*[@id='bodyCell']//h1")
	WebElement validateLeadPage;

	@FindBy(xpath = "//select[@id='fcf']")
	List<WebElement> viewDropdownList;

	@FindBy(xpath = "//select[@name='fcf']")
	WebElement viewDropdown2;

	@FindBy(xpath = "//*[@id='filter_element']/div/span/span[1]/input")
	WebElement GoBtn;

	@FindBy(xpath = "//*[@id='bodyCell']")
	WebElement todayPageValidation;

	@FindBy(xpath = "//*[@id='hotlist']/table/tbody/tr/td[2]/input")
	WebElement newBtn;

	@FindBy(xpath = "//*[@id='name_lastlea2']")
	WebElement lastNameBox;
	
	@FindBy(xpath = "//*[@id='lea3']")
	WebElement companyBox;
	
	@FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
	WebElement saveBtn;

	public void LeadTab() {
		leadTab.click();
		Assert.assertEquals("Leads", validateLeadPage.getText());
		log.info("Leads Page found");
	}

	public void createLead() {
		leadTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(newBtn));
		newBtn.click();
	}

	public void displayAlOptions() {
		wait.until(ExpectedConditions.visibilityOfAllElements(viewDropdownList));
		for (WebElement viewlist : viewDropdownList) {
			System.out.println("Available options are:" + viewlist.getText());
		}

	}

	public void selectViewFromList(String viewName) {
		wait.until(ExpectedConditions.elementToBeClickable(viewDropdown2));
		// wait.until(ExpectedConditions.elementToBeClickable(viewName);
		CommonUtils.selectValues(viewDropdown2, viewName);
		System.out.println("Today's Leads selected from dropdown");

	}

	public String getFirstSelectedOption() {
		wait.until(ExpectedConditions.elementToBeClickable(viewDropdown2));
		Select select = new Select(viewDropdown2);
		return select.getFirstSelectedOption().getText();
	}

	public void GoButton() {
		wait.until(ExpectedConditions.elementToBeClickable(GoBtn));
		GoBtn.click();
	}

	public void validateTodayPage() {
		String PageTitle = driver.getTitle();
		System.out.println("PageTitle is:" + PageTitle);
	}

	public void validateMenuSelect(String viewName) {
		leadTab.click();
		if (validateLeadPage.getText().contains("Leads")) {
			System.out.println("Page validated");
		} else {
			System.out.println("Page not validated.");
		}
		wait.until(ExpectedConditions.visibilityOfAllElements(viewDropdownList));
		CommonUtils.selectValues(viewDropdown2, viewName);
	}

	public void leadInfo(String lastname, String companyname) {
		wait.until(ExpectedConditions.visibilityOf(lastNameBox));
		lastNameBox.sendKeys(lastname);
		wait.until(ExpectedConditions.visibilityOf(companyBox));
		companyBox.sendKeys(companyname);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	}

}
