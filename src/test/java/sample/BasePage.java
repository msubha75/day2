package sample;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	HashMap<String, WebElement> elementMap;

	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		System.out.println("Parent Cons");
	}

	
	public void clickElement(String elementName) {
		wait.until(ExpectedConditions.elementToBeClickable(elementMap.get(elementName)));
		elementMap.get(elementName).click();
	}
		
	public String getElementText(String elementName) {
		wait.until(ExpectedConditions.visibilityOf(elementMap.get(elementName)));
		return elementMap.get(elementName).getText();
	}

}
