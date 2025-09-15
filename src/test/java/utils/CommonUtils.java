package utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CommonUtils {

	public static void sleepThread(Integer waitTime) {
		try {
			Thread.sleep(Duration.ofSeconds(waitTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

		public static void selectValues(WebElement element, String option) {
			Select select = new Select(element);
			select.selectByContainsVisibleText(option);
		}

}
