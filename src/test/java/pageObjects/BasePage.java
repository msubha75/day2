package pageObjects;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Map<String, WebElement> elementMap;

	public BasePage(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void clickElement(String elementName) {
		wait.until(ExpectedConditions.elementToBeClickable(elementMap.get(elementName)));
		elementMap.get(elementName).click();
	}

	public String getElementText(String elementName) {
		wait.until(ExpectedConditions.visibilityOf(elementMap.get(elementName)));
		return elementMap.get(elementName).getText();
	}

	public void sendText(String elementName, String textValue) {
		wait.until(ExpectedConditions.elementToBeClickable(elementMap.get(elementName)));
		elementMap.get(elementName).clear();
		elementMap.get(elementName).sendKeys(textValue);
	}
}
