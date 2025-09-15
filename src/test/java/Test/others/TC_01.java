package Test.others;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TC_01 {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		// options.addArguments("--disable-features=PasswordCheck");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://qa-tekarch.firebaseapp.com/");
		driver.findElement(By.xpath("//*[@id='email_field']")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		driver.findElement((By.xpath("//*[@id='login_div']/button"))).click();

		// sleepWait(5);

		System.out.println("Logged in and popup disabled successfully.");
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Subha");
		driver.findElement(By.xpath("//*[@id='lname']")).sendKeys("Meenakshisundaram");
		driver.findElement(By.xpath("//*[@id='postaladdress']")).sendKeys("28277");
		driver.findElement(By.xpath("//*[@id=\'personaladdress\']")).sendKeys("14320 wynhollow down's lane");
		WebElement female = driver.findElement(By.xpath("//*[@id='radiobut' and @value='female']"));
		female.click();
		WebElement dropdowncity = driver.findElement(By.id("city"));
		Select city = new Select(dropdowncity);
		city.selectByIndex(2);
		// dropdown.selectByValue("goa");
		WebElement selected = city.getFirstSelectedOption();
		System.out.println("Selected city: " + selected.getText());

		WebElement dropdowncourse = driver.findElement(By.xpath("//*[@id='course']"));
		Select course = new Select(dropdowncourse);
		course.selectByIndex(1);
		WebElement selectcourse = course.getFirstSelectedOption();
		System.out.println("Selected course: " + selectcourse.getText());
		WebElement dropdowndistrict = driver.findElement(By.xpath("//*[@id='district']"));
		Select district = new Select(dropdowndistrict);
		district.selectByIndex(1);
		WebElement selectdistrict = district.getFirstSelectedOption();
		System.out.println("Selected district: " + selectdistrict.getText());
		WebElement dropdownstate = driver.findElement(By.xpath("//*[@id='state']"));
		Select state = new Select(dropdownstate);
		state.selectByIndex(1);
		WebElement selectstate = district.getFirstSelectedOption();
		System.out.println("Selected district: " + selectstate.getText());
		WebElement pincode = driver.findElement(By.xpath("//*[@id='pincode']"));
		pincode.sendKeys("12345");
		WebElement email = driver.findElement(By.xpath("//*[@id='emailid']"));
		email.sendKeys("xyz@gmail.com");
		WebElement submit = driver.findElement(By.xpath("//*[@id='user_div']/div[2]/div/span/button"));
		submit.click();
		System.out.println("Form submitted");
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
