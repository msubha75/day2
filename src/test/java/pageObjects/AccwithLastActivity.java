package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;

public class AccwithLastActivity {
	WebDriver driver;
	WebDriverWait wait;

	public AccwithLastActivity(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='thePage:sectionHeader']/div/div/div[1]/h2")
	WebElement pageValidation;
	@FindBy(xpath = "//*[@id='ext-gen20']")
	WebElement dateField;
	@FindBy(xpath = "//*[@id='ext-comp-1042']")
	WebElement FromDate;
	@FindBy(xpath = "//*[@id='ext-comp-1045']")
	WebElement EndDate;
	/*
	 * @FindBy(xpath = "//*[@id='ext-gen297']") WebElement Today;
	 */

	public void validatePage() {
		if (pageValidation.getText().contains("Unsaved Report")) {
			System.out.println("Validated");
		} else {
			System.out.println("Not validated");
		}

		String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy"));

		CommonUtils.selectValues(dateField, "CreatedDate");
		CommonUtils.selectValues(FromDate, "Today");
		CommonUtils.selectValues(EndDate, "Today");

	}
}