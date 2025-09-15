package sample;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(xpath = "//*[@id='Lead_Tab']/a")
	WebElement leadTab;

	@FindBy(xpath = "//*[@id='username']")
	WebElement usernameBox;

	public HomePage(WebDriver driver) {
		super(driver);
		System.out.println("Child Cons");
	}

	{
		elementMap = new HashMap<String, WebElement>();
		elementMap.put("usernameBox", usernameBox);
		elementMap.put("leadTab", leadTab);

		System.out.println("Child IIB");
	}
}
