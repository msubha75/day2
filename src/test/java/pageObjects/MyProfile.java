package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfile {

	WebDriver driver;
	WebDriverWait wait;

	public MyProfile(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img")
	WebElement editBtn;
	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	WebElement userName;
	@FindBy(xpath = "//*[@id='chatterTab']/div[2]/div[2]/div[2]/div/a]")
	WebElement contactEmail;
	@FindBy(xpath = "//*[@id='profileTab_sfdc.ProfilePlatformFeed']")
	WebElement Feed;
	@FindBy(xpath = "//*[@id='publisherAttachTextPost']")
	WebElement Post;
	
	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	WebElement File;
	@FindBy(xpath = "//a[@id='profileTab_sfdc.ProfilePlatformOverview']")
	WebElement Overview;
	@FindBy(xpath = "//*[@id='knowledgeableAbout']/div[1]")
	WebElement knowAboutTab;
	@FindBy(xpath = "//*[@id='profileAboutMe']/div")
	WebElement aboutMe;
	

	public void editContact() {
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		editBtn.click();
	}

	public void validateEditBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		editBtn.click();
	}
		public void validatePage() {
		wait.until(ExpectedConditions.visibilityOf(Feed));
		System.out.println("The element Feed is present");
		Feed.click();
		wait.until(ExpectedConditions.visibilityOf(Post));
		System.out.println("The element Post is present");
		wait.until(ExpectedConditions.visibilityOf(File));
		System.out.println("The element File is present");
		wait.until(ExpectedConditions.visibilityOf(Overview));
		System.out.println("The element Overview is present");
		Overview.click();
		wait.until(ExpectedConditions.visibilityOf(knowAboutTab));
		System.out.println("The element knowAboutTab is present");
		wait.until(ExpectedConditions.visibilityOf(aboutMe));
		System.out.println("The element aboutMe is present");
		
	}

	public String getProfileName() {
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		return userName.getText();
	}

	public String getProfileContactEmail() {
		wait.until(ExpectedConditions.elementToBeClickable(contactEmail));

		return contactEmail.getText();

	}

}
