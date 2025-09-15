package pageObjects;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPanel {

	WebDriver driver;
	WebDriverWait wait;
	private static final Logger log = Logger.getLogger(TopMenuPanel.class);

	// Top Menu Panel

	@FindBy(xpath = "//*[@id='userNavLabel']")
	WebElement usermenu;

	@FindBy(xpath = "//*[@id='userNav-menuItems']/*[@title='My Profile']")
	WebElement myProfileOption;

	@FindBy(xpath = "//*[@id='userNav-menuItems']/*[@title='My Settings']")
	WebElement mySettingsOption;

	@FindBy(xpath = "//li[@id='home_Tab']")
	WebElement homeTab;

	@FindBy(xpath = "//li[@id='Account_Tab']")
	WebElement accountTab;

	@FindBy(xpath = "//li[@id='Contact_Tab']")
	WebElement contactTab;
	@FindBy(xpath = "//li[@id='Opportunity_Tab']")
	WebElement Opportunities;
	@FindBy(xpath = "//a[@title='Chatter Tab']")
	WebElement ChatterTab;

	@FindBy(xpath = "//a[@title='Logout']")
	WebElement logoutOption;
	@FindBy(xpath = "//a[@href='/home/showAllTabs.jsp']")
	WebElement allTabs;
	@FindBy(xpath = "//*[@id='Lead_Tab']/a")
	WebElement leadTab;

	// Left Menu Panel

	@FindBy(id = "createNewLabel")
	WebElement createNewMenu;

	@FindBy(xpath = "//*[contains(@class, 'accountMru')]")
	WebElement createNewAccount;

	@FindBy(xpath = "//*[contains(@class, 'contactMru')]")
	WebElement createNewContact;

	public TopMenuPanel(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void selectUserMenu(String menuOption) {
		wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(usermenu));
		usermenu.click();

		switch (menuOption) {
		case "My Profile":
			wait.until(ExpectedConditions.visibilityOf(myProfileOption));
			myProfileOption.click();
			break;
		case "My Settings":
			wait.until(ExpectedConditions.visibilityOf(mySettingsOption));
			mySettingsOption.click();
			break;
		case "Logout":
			wait.until(ExpectedConditions.visibilityOf(logoutOption));
			logoutOption.click();
			break;
		default:
			System.out.println(menuOption + " Option not found.");
		}
	}

	public void selectCreateMenu(String menuOption) {
		wait.until(ExpectedConditions.elementToBeClickable(createNewMenu));
		createNewMenu.click();

		switch (menuOption) {
		case "Account":
			wait.until(ExpectedConditions.visibilityOf(createNewAccount));
			createNewAccount.click();
			break;
		case "Contact":
			wait.until(ExpectedConditions.visibilityOf(createNewContact));
			createNewContact.click();
			break;
		default:
			System.out.println(menuOption + " Option not found.");
		}
	}

	public void selectTopPanelMenu(String menuOption) {

		switch (menuOption) {
		case "Home":
			wait.until(ExpectedConditions.visibilityOf(homeTab));
			homeTab.click();
			break;
		case "Accounts":
			wait.until(ExpectedConditions.visibilityOf(accountTab));
			accountTab.click();
			break;
		case "Contacts":
			wait.until(ExpectedConditions.visibilityOf(contactTab));
			contactTab.click();
			break;
		case "Opportunities":
			wait.until(ExpectedConditions.visibilityOf(Opportunities));
			Opportunities.click();
			break;

		case "ChatterTab":
			wait.until(ExpectedConditions.visibilityOf(ChatterTab));
			ChatterTab.click();
			break;
		case "AllTabs":
			wait.until(ExpectedConditions.visibilityOf(allTabs));
			allTabs.click();
			break;
		case "Leads":
			wait.until(ExpectedConditions.visibilityOf(leadTab));
			leadTab.click();
			log.info(menuOption+" is selected");
			break;
		default:
			log.info(menuOption + " Option not found.");
		}
	}

}
