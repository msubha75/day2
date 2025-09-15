package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPanel {

	WebDriver driver;
	WebDriverWait wait;

	public EditPanel(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='contactInfoContentId']")
	WebElement contentInfoFrame;
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement editProfile;
	@FindBy(xpath = "//*[@id='aboutTab']")
	WebElement aboutTab;
	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement contactTab;
	@FindBy(xpath = "//*[@id='lastName']")
	WebElement LastName;
	@FindBy(xpath = "//*[@value='Save All']")
	WebElement SaveAll;
	@FindBy(xpath = "//*[@id='userNavButton']")
	WebElement usernameMenuBtn;
	@FindBy(id = "tailBreadcrumbNode")
	WebElement usernameValidation_HomePage;
	

	public void editProfileicon() {
		wait.until(ExpectedConditions.elementToBeClickable(editProfile));
		editProfile.click();
	}

	public void verifyContactTabSelected() {
		driver.switchTo().frame(contentInfoFrame);
		wait.until(ExpectedConditions.visibilityOf(contactTab));
		System.out.println("Contacttab selected");
	}

	public void selectAboutTab() {
		// driver.switchTo().frame(contentInfoFrame);
		wait.until(ExpectedConditions.elementToBeClickable(aboutTab));
		aboutTab.click();
	}

	public void setLastName(String Name) {

		wait.until(ExpectedConditions.visibilityOf(LastName));
		LastName.clear();
		LastName.sendKeys(Name);

	}

	public void SaveBtn() {
		wait.until(ExpectedConditions.visibilityOf(SaveAll));
		SaveAll.click();
	}

	public String usrnameMenuValidation() {
		wait.until(ExpectedConditions.visibilityOf(usernameMenuBtn));
		return usernameMenuBtn.getText();
	}

	public String usrnamechangeValidation() {
		wait.until(ExpectedConditions.visibilityOf(usernameValidation_HomePage));
		return usernameValidation_HomePage.getText();
	}

}
