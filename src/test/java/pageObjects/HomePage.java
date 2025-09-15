package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a")
	WebElement userName;

	@FindBy(xpath = "//*[@class='pageDescription']/a")
	WebElement currentDate;

	@FindBy(xpath = "//a[normalize-space()='8:00 PM']")
	WebElement clickTimeLink;

	@FindBy(xpath = "//a[normalize-space()='4:00 PM']")
	WebElement selectTime;

	@FindBy(xpath = "//*[@id='ep']/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a")
	WebElement subjectcombolink;

	@FindBy(xpath = "//li/a")
	List<WebElement> elements;

	@FindBy(xpath = "//*[contains(@id, 'timePickerItem')]")
	List<WebElement> timepicker;

	@FindBy(xpath = "//*[@id='StartDateTime_time']")
	WebElement startDatebox;

	@FindBy(xpath = "//*[@id='EndDateTime_time']")
	WebElement EndDatebox;

	@FindBy(xpath = "//*[contains(@class, 'simpleHour')]")
	List<WebElement> endTimePicker;

	@FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
	WebElement saveBtn;
	@FindBy(xpath = "//*[@id='IsRecurrence']")
	WebElement createRecurringseries;
	@FindBy(xpath = "//div[*[@name='rectype']]/label")
	List<WebElement> radioBtnList;
	@FindBy(xpath = "//*[@id='wi']")
	WebElement recurringNumber;
	@FindBy(xpath = "//div[*[@type='checkbox' and @id=1]]/input")
	List<WebElement> dayscheckbox;
	@FindBy(xpath = "//div[*[@type='checkbox' and @id=1]]/label")
	List<WebElement> daysLabel;
	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement save;
	@FindBy(xpath = "//*[@id='RecurrenceStartDateTime']")
	WebElement startDate;
	@FindBy(xpath = "//*[@id='RecurrenceEndDateOnly']")
	WebElement endDate;

	public void clickUserName() {
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.click();
	}

	public void clickCurrentDateLink() {
		wait.until(ExpectedConditions.elementToBeClickable(currentDate));
		currentDate.click();
	}

	public void clicktime() {
		wait.until(ExpectedConditions.elementToBeClickable(clickTimeLink));
		clickTimeLink.click();
	}

	public void selecttimelink() {
		wait.until(ExpectedConditions.elementToBeClickable(selectTime));
		selectTime.click();
	}

	public void selectSubject(String choiceValue) {
		wait.until(ExpectedConditions.elementToBeClickable(subjectcombolink));
		subjectcombolink.click();
		String mainHandle = driver.getWindowHandle();
		System.out.println("Switched: " + driver.getTitle());
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainHandle)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switched: " + driver.getTitle());
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		System.out.println(elements.size());
		for (WebElement element : elements) {
			System.out.println(element.getText());
			if (element.getText().equals(choiceValue)) {
				element.click();
				break;
			}
		}
		driver.switchTo().window(mainHandle);
	}

	public void selectTime(String startTime, String endTime) {
		wait.until(ExpectedConditions.visibilityOf(startDatebox));
		startDatebox.click();
		for (WebElement selecttime : timepicker) {
			System.out.println(selecttime.getText());
			if (selecttime.getText().equals(startTime)) {
				selecttime.click();
			}
		}

		wait.until(ExpectedConditions.visibilityOf(EndDatebox));
		EndDatebox.click();
		for (WebElement selectendTime : endTimePicker) {
			System.out.println(selectendTime.getText());
			if (selectendTime.getText().equals(endTime)) {
				selectendTime.click();
			}
		}
	}

	public void clickSave() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	}

	public void checkCreateRecurringEvents() {
		wait.until(ExpectedConditions.elementToBeClickable(createRecurringseries));
		createRecurringseries.click();
		System.out.println("Recurring series checked");
	}

	public void selectFrquency(String option, String value, String day) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				radioBtnList.get(0));
		for (WebElement selectedfrequency : radioBtnList) {
			wait.until(ExpectedConditions.visibilityOfAllElements(selectedfrequency));
			if (selectedfrequency.getText().equals(option)) {
				selectedfrequency.click();
				System.out.println(selectedfrequency.getText());
				break;
			}
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", recurringNumber);
		wait.until(ExpectedConditions.visibilityOf(recurringNumber));
		recurringNumber.sendKeys(value);
		for (WebElement selectedday : dayscheckbox) {
			wait.until(ExpectedConditions.elementToBeClickable(selectedday));
			if (selectedday.isSelected()) {
				selectedday.click();
			}
		}
		for (WebElement selectedday : daysLabel) {
			if (selectedday.getText().equals(day)) {
				selectedday.click();
				break;
			}
		}
	}

	public void save() {
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
	}

	public void selectdate(String startdate, String enddate) {
		wait.until(ExpectedConditions.visibilityOf(startDate));
		startDate.clear();
		startDate.sendKeys(startdate);
		wait.until(ExpectedConditions.visibilityOf(endDate));
		endDate.sendKeys(enddate);
	}
}
