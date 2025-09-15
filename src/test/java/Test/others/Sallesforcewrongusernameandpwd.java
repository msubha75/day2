package Test.others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sallesforcewrongusernameandpwd {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("qwe");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");

		WebElement Login = driver.findElement(By.xpath("//*[@id='Login']"));
		wait.until(ExpectedConditions.elementToBeClickable(Login));
		Login.click();
		WebElement ErrorMessage=driver.findElement(By.xpath("//*[@id='error']"));
		System.out.println(ErrorMessage.getText());
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
