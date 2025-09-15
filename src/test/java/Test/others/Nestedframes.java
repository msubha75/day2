package Test.others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nestedframes {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("frame1");
		WebElement ParentElement = driver.findElement(By.tagName("body"));
		String ParentText=ParentElement.getText();
		System.out.println("Parent frame:" + ParentText);
		driver.switchTo().frame(0);
		WebElement childElement = driver.findElement(By.tagName("p"));
		String childText = childElement.getText();
		System.out.println("Text from child frame: " + childText);
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

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