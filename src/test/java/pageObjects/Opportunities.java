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

import utils.CommonUtils;

public class Opportunities {

	WebDriver driver;
	WebDriverWait wait;

	public Opportunities(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@id='Opportunity_Tab']")
	WebElement OpportunitiesTab;

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement dropDown;

	@FindBy(xpath = "//*[contains(@class,'fBody')]")
	List<WebElement> Options;

	@FindBy(xpath = "//input[@title='New']")
	WebElement clickNew;

	@FindBy(xpath = "//h2[normalize-space()='New Opportunity']")
	WebElement TitlePage;

	@FindBy(xpath = "//input[@id='opp3']")
	WebElement OpportunityName;

	@FindBy(xpath = "//*[@id='opp4_lkwgt']")
	WebElement Accnamelookup;

	@FindBy(xpath = "//*[contains(@class, 'dataRow')]")
	List<WebElement> dataRows;

	@FindBy(xpath = "//*[@id='opp6']")
	WebElement LeadSource;

	@FindBy(xpath = "//*[@id='opp11']")
	WebElement Stage;

	@FindBy(xpath = "//input[@id='opp12']")
	WebElement Probablity;

	@FindBy(xpath = "//input[@id='opp17']")
	WebElement PrimarySource;

	@FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
	WebElement SaveBtn;

	@FindBy(xpath = "//a[normalize-space()='Opportunity Pipeline']")
	WebElement opportunityPipline;

	@FindBy(xpath = "//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]")
	WebElement Validationpage;

	@FindBy(xpath = "//a[normalize-space()='Stuck Opportunities']")
	WebElement StuckOpportunities;

	@FindBy(xpath = "//div[@class='bPageTitle']")
	WebElement pageValidation;

	@FindBy(xpath = "//*[@id='toolsContent']/tbody/tr/td[2]/div/div/h3")
	WebElement quaterlySummary;

	@FindBy(xpath = "//*[@id='quarter_q']")
	WebElement intervaldropdown;

	@FindBy(xpath = "//*[@id='open']")
	WebElement includedropdown;

	@FindBy(xpath = "//input[@title='Run Report']")
	WebElement run;

	public void OpportunitiesTabClick() {
		OpportunitiesTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		dropDown.click();
		for (WebElement Option : Options) {
			System.out.println("Available Options are:" + Option.getText());
		}
	}

	public void newOpportunities(String optyname, String campaignname, String accname) {
		wait.until(ExpectedConditions.visibilityOf(clickNew));
		clickNew.click();

		if (TitlePage.getText().contains("New Opportunity")) {
			System.out.println("Page validated");
		} else {
			System.out.println("Page not validated");
		}
		wait.until(ExpectedConditions.visibilityOf(OpportunityName));
		OpportunityName.sendKeys(optyname);
		wait.until(ExpectedConditions.visibilityOf(Accnamelookup));
		Accnamelookup.click();
		String mainHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainHandle)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switched: " + driver.getTitle());
			}
		}
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='Results']")));
		wait.until(ExpectedConditions.visibilityOfAllElements(dataRows));

		for (WebElement datarow : dataRows) {
			wait.until(ExpectedConditions.elementToBeClickable(datarow));
			WebElement testuser = datarow.findElement(By.xpath("./th/a"));
			System.out.println("Available options:" + testuser.getText());
			if (accname.equals(testuser.getText())) {
				testuser.click();
				break;
			}
		}
		driver.switchTo().window(mainHandle);
		// SelectTestUser.click();
		CommonUtils.selectValues(LeadSource, "Partner Referral");
		wait.until(ExpectedConditions.visibilityOf(Stage));
		CommonUtils.selectValues(Stage, "Prospecting");
		Probablity.clear();
		Probablity.sendKeys("100");
		PrimarySource.sendKeys(campaignname);
		SaveBtn.click();
	}

	public void validatePipeline() {
		wait.until(ExpectedConditions.elementToBeClickable(opportunityPipline));
		opportunityPipline.click();
		if (Validationpage.getText().contains("Opportunity Pipeline")) {
			System.out.println("Page validated");
		} else {
			System.out.println("Page not vaidated");
		}
	}

	public void validateStuckOpportunities() {
		wait.until(ExpectedConditions.elementToBeClickable(StuckOpportunities));
		StuckOpportunities.click();
		if (pageValidation.getText().contains("Stuck Opportunities")) {
			System.out.println("Page validated");
		} else {
			System.out.println("Page not validated");
		}
	}

	public void runReport(String intervalOption, String includeOption) {
		wait.until(ExpectedConditions.visibilityOf(quaterlySummary));
		CommonUtils.selectValues(intervaldropdown, intervalOption);
		CommonUtils.selectValues(includedropdown, includeOption);
		wait.until(ExpectedConditions.elementToBeClickable(run));
		run.click();
	}

}
