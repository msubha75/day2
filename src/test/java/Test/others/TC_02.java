package Test.others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_02 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/checkbox");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement Homeexpandbutton = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button"));
		wait.until(ExpectedConditions.elementToBeClickable(Homeexpandbutton)).click();
		WebElement DesktopCheckbox = driver
				.findElement(By.xpath("//*[@id=\'tree-node\']/ol/li/ol/li[1]/span/label"));
		wait.until(ExpectedConditions.elementToBeClickable(DesktopCheckbox)).click();
		System.out.println("Child DesktopCheckbox checked successfully.");
		WebElement DownloadCheckbox = driver
				.findElement(By.xpath("//*[@id=\'tree-node\']/ol/li/ol/li[3]/span/label"));
		
		wait.until(ExpectedConditions.elementToBeClickable(DownloadCheckbox)).click();
		System.out.println("Child DownloadCheckbox checked successfully.");
		
		
		/*
		 * String Result=driver.findElement(By.xpath("//*[@id=\'result\']")).getText().
		 * toLowerCase();
		 * 
		 * if (Result.contains("downloads") && Result.contains("desktop")) {
		 * System.out.println("Both 'downloads' and 'desktop' are checked."); } else {
		 * System.out.println("One or more checkboxes not confirmed in result."); }
		 */
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
