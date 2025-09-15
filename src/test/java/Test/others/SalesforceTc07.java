package Test.others;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceTc07 {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("msubha75762@agentforce.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Tiru@1994");

		WebElement Login = driver.findElement(By.xpath("//*[@id='Login']"));
		wait.until(ExpectedConditions.elementToBeClickable(Login));
		Login.click();

		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		wait.until(ExpectedConditions.elementToBeClickable(userMenu));

		userMenu.click();
		WebElement optionSetting = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(optionSetting));
		optionSetting.click();
		System.out.println("Setting option clicked");

		WebElement PersonalInfo = driver.findElement(By.xpath("//a[@class='header setupFolder']"));
		wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo));
		PersonalInfo.click();
		System.out.println("Personal Info clicked");
		WebElement LoginHistory = driver.findElement(By.xpath("//*[@id='LoginHistory_font']"));
		wait.until(ExpectedConditions.elementToBeClickable(LoginHistory));
		LoginHistory.click();
		System.out.println("LoginHistory clicked");
		WebElement DownloadHistory = driver.findElement(By.xpath("//*[@id='RelatedUserLoginHistoryList_body']/div/a"));
		wait.until(ExpectedConditions.elementToBeClickable(DownloadHistory));
		DownloadHistory.click();
		System.out.println("History Downloaded");
		WebElement DisplayAndLayout = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout\"]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(DisplayAndLayout));
		DisplayAndLayout.click();
		System.out.println("DisplayAndLayout clicked");

		WebElement CustomizeMyTab = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_child\"]/div[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CustomizeMyTab));
		CustomizeMyTab.click();
		System.out.println("CustomizeMyTab clicked");
		WebElement CustomApp = driver.findElement(By.xpath("//*[@id='p4']"));
		Select Sales = new Select(CustomApp);
		Sales.selectByIndex(8);
		System.out.println("Salesforce Chatter selected from dropdown");

		WebElement dropdownoptions = driver.findElement(By.id("duel_select_0"));
		Select select = new Select(dropdownoptions);
		List<WebElement> test = select.getOptions();
		boolean isReportsAvailable = false;
		for (int i = 0; i < test.size(); i++) {
			if ("Reports".equals(test.get(i).getText())) {
				isReportsAvailable = true;
				break;
			}
		}

		if (isReportsAvailable) {
			select.selectByVisibleText("Reports");
			WebElement addButton = driver.findElement(By.xpath("//*[@id='duel_select_0_right']"));
			wait.until(ExpectedConditions.elementToBeClickable(addButton));
			addButton.click();
		}
		WebElement selectedOptions = driver.findElement(By.id("duel_select_1"));
		Select select1 = new Select(selectedOptions);
		List<WebElement> test1 = select1.getOptions();
		boolean isReportsAdded = false;
		for (int i = 0; i < test1.size(); i++) {
			if ("Reports".equals(test1.get(i).getText())) {
				isReportsAdded = true;
				break;
			}
		}

		if (isReportsAdded) {
			System.out.println("Reports added");
		}

		WebElement SaveButton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		SaveButton.click();

		System.out.println("Changes saved");
		System.out.println("Report tab is present");
		WebElement Emailbutton = driver.findElement(By.xpath("//*[text()='Email']"));
		wait.until(ExpectedConditions.elementToBeClickable(Emailbutton));
		Emailbutton.click();
		WebElement EmailSettings = driver.findElement(By.xpath("//*[@id=\"EmailSetup_child\"]/div[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(EmailSettings));
		EmailSettings.click();
		System.out.println("My Email Setting Page displayed");
		WebElement SenderName = driver.findElement(By.xpath("//*[@id='sender_name']"));
		SenderName.clear();
		SenderName.sendKeys("Subha Meenakshisundaram");
		WebElement SenderEmail = driver.findElement(By.xpath("//*[@id=\"sender_email\"]"));
		SenderEmail.clear();
		SenderEmail.sendKeys("msubha75@gmail.com");

		WebElement Autobcc = driver.findElement(By.xpath("//*[@id='auto_bcc1']"));
		Autobcc.click();
		WebElement SaveChanges = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		SaveChanges.click();
		System.out.println("Changes saved");
		WebElement CalenderandReminder = driver.findElement(By.xpath("//*[@id='CalendarAndReminders']"));
		wait.until(ExpectedConditions.elementToBeClickable(CalenderandReminder));
		CalenderandReminder.click();
		System.out.println("CalenderandReminder clicked");
		WebElement ActivityReminder = driver.findElement(By.xpath("//*[@id=\"CalendarAndReminders_child\"]/div[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(ActivityReminder));
		ActivityReminder.click();
		System.out.println("ActivityReminder clicked");
		WebElement OpenTestReminder = driver.findElement(By.xpath("//*[@id='testbtn']"));
		wait.until(ExpectedConditions.elementToBeClickable(OpenTestReminder));
		OpenTestReminder.click();
		sleepWait(5);
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			if ("** New **".equals(driver.getTitle())) {
				break;
			}
		}
		driver.findElement(By.xpath("//*[contains(text(), 'Sample Task.')]"));
		System.out.println("Pop-up displayed");

		for (String window : windows) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			if ("Activity Reminders ~ Salesforce - Developer Edition".equals(driver.getTitle())) {
				break;
			}
		}
		WebElement userMenu1 = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(userMenu1));

		userMenu1.click();
		WebElement Logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		wait.until(ExpectedConditions.elementToBeClickable(Logout));
		Logout.click();
		sleepWait(5);
		driver.quit();

	}

	public static void sleepWait(Integer duration) {
		try {
			Thread.sleep(Duration.ofSeconds(duration));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
