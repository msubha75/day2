package Test.others;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Salesforceforgotpwd {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://login.salesforce.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement ForgotPassword=driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
	wait.until(ExpectedConditions.elementToBeClickable(ForgotPassword)).click();
	driver.findElement(By.xpath("//*[@id='un']")).sendKeys("msubha75762@agentforce.com");
	WebElement ContinueButton=driver.findElement(By.xpath("//*[@id='continue']"));
	wait.until(ExpectedConditions.elementToBeClickable(ContinueButton)).click();
	WebElement ForgotPasswordform=driver.findElement(By.xpath("//*[@id='forgotPassForm']/div"));
	System.out.println("ForgotPasswordform says:"+ForgotPasswordform.getText());

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
