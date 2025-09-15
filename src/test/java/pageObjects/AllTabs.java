package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;

public class AllTabs {
	WebDriver driver;
	WebDriverWait wait;

	public AllTabs(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@title='Customize My Tabs']")
	WebElement customizeMyTab;
	@FindBy(xpath = "//*[@id='duel_select_1']/option[14]")
	WebElement chatterTab;
	@FindBy(xpath = "//a[@id='duel_select_0_left']")
	WebElement removeTab;
	@FindBy(xpath = "//input[@title='Save']")
	WebElement saveIcon;
	@FindBy(xpath = "//*[@id='tabBar']")
	List<WebElement> tabBar;
	@FindBy(xpath = "//*[@id='duel_select_0']/option[19]")
	WebElement addChatter;
	@FindBy(xpath = "//*[@id='duel_select_0_right']")
	WebElement addTab;
	@FindBy(xpath = "//*[@id='bodyCell']/div[3]/div[1]/table/tbody/tr/td[2]/input")
	WebElement customizeMytabBtn;
	@FindBy(xpath = "//*[@id='duel_select_0']")
	WebElement availableTabs;
	
	@FindBy(xpath = "//*[@id='duel_select_1']")
	WebElement selectedTab;

	public void clickCutomizeTab() {
		wait.until(ExpectedConditions.elementToBeClickable(customizeMyTab));
		customizeMyTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(chatterTab));

		chatterTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(removeTab));
		removeTab.click();

		System.out.println("Tab removed");
	}

	public void saveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(saveIcon));
		saveIcon.click();
		System.out.println("Changes saved");
	}

	public void validatePage(String tabName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(tabBar));
		for (WebElement element : tabBar) {
			if (element.getText().contains(tabName)) {
				System.out.println("Element not removed");
			} else {
				System.out.println("Element removed");
			}
		}
	}

	public void customizeMytabclick() {
		wait.until(ExpectedConditions.elementToBeClickable(customizeMytabBtn));
		customizeMytabBtn.click();
	}

	public void addtab(String tabName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(availableTabs));
		CommonUtils.selectValues(availableTabs, tabName);
		wait.until(ExpectedConditions.elementToBeClickable(addTab));
		addTab.click();
		System.out.println(tabName+" Tab added");
	}

	public void removeTab(String tabName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(selectedTab));
		CommonUtils.selectValues(selectedTab, tabName);
		wait.until(ExpectedConditions.elementToBeClickable(removeTab));
		removeTab.click();
		System.out.println(tabName+" Tab removed");
	}

}
