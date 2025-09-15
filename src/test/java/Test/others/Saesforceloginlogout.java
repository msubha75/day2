package Test.others;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Saesforceloginlogout {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 1);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("msubha75762@agentforce.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Tiru@1994");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement RemembermeCheckbox = driver.findElement(By.xpath("//*[@id=\'rememberUn\']"));
		wait.until(ExpectedConditions.elementToBeClickable(RemembermeCheckbox)).click();
		System.out.println("Rememberme checked successfully.");

		driver.findElement(By.xpath("//*[@id='Login']")).click();
 
		WebElement UserImage=driver.findElement(By.xpath("//*[@id=\'oneHeader\']/div[2]/span/div[2]/ul/li[7]"));
		wait.until(ExpectedConditions.elementToBeClickable(UserImage)).click();
		WebElement Logout = driver.findElement(By.partialLinkText("Log"));
		wait.until(ExpectedConditions.elementToBeClickable(Logout));
		Logout.click();
		System.out.println("Loggedout successfully.");
		WebElement UserName=driver.findElement(By.xpath("//*[@id='username']"));
		System.out.println("UserName is:"+UserName.getAttribute("value"));

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
