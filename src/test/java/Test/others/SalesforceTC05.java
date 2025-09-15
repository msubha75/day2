package Test.others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceTC05 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("msubha75762@agentforce.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Tiru@1994");

		WebElement Login = driver.findElement(By.xpath("//*[@id='Login']"));
		wait.until(ExpectedConditions.elementToBeClickable(Login));
		Login.click();
		WebElement UserMenu = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(UserMenu));
		actions.moveToElement(UserMenu).click().perform();

		WebElement SubElement = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(SubElement));
		SubElement.click();
		WebElement EditTab = driver.findElement(By.xpath("//div[@class='editPen']/a/img"));
		wait.until(ExpectedConditions.elementToBeClickable(EditTab));
		EditTab.click();
		System.out.println("Edit icon clicked.");
		driver.switchTo().frame("contactInfoContentId");

		WebElement AboutTab = driver.findElement(By.xpath("//a[contains(text(), 'About')]"));
		wait.until(ExpectedConditions.elementToBeClickable(AboutTab));
		AboutTab.click();
		System.out.println("Successfully navigated to About tab.");
		WebElement LastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		LastName.clear();
		LastName.sendKeys("Meenakshi sundaram");
		WebElement SaveAll = driver.findElement(By.xpath("//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(SaveAll));
		SaveAll.click();

		System.out.println("Lastname updated");
		sleepWait(5);

		driver.switchTo().frame(1);
		WebElement Post = driver.findElement(By.id("publisherAttachTextPost"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='publisherAttachTextPost']")));
		Post.click();
		System.out.println("Posted");
		WebElement Textbox = driver
				.findElement(By.xpath("//*[contains(text(),‘Share an update, @mention someone...’)]"));
		Textbox.sendKeys("Hello");
		WebElement Share = driver.findElement(By.xpath("//*[@id='publishersharebutton']"));
		wait.until(ExpectedConditions.elementToBeClickable(Share));
		Share.click();
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
