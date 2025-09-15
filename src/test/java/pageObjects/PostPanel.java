package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostPanel {
	WebDriver driver;
	WebDriverWait wait;

	public PostPanel(WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//*[@title='post']")
	WebElement postLink;
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
     WebElement Post;
	@FindBy(xpath ="//input[@id='publishersharebutton']")
	WebElement shareBtn;
	public void postLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(postLink));
		postLink.click();
	}
	public void postInfo(String text)
	{
		
	driver.switchTo().frame(Post);
	wait.until(ExpectedConditions.visibilityOf(Post));
	Post.sendKeys(text);
	}
	public void shareBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(shareBtn));
		shareBtn.click();	
}

}
