package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;

public class ContactMenu extends BasePage {

	@FindBy(xpath = "//*[@id='hotlist']/table/tbody/tr/td[2]/input")
	WebElement newBtn;

	@FindBy(xpath = "//*[@id='name_lastcon2']")
	WebElement lastNameBox;

	@FindBy(xpath = "//img[@title='Account Name Lookup (New Window)']")
	WebElement AccnameLookup;

	@FindBy(xpath = "//*[contains(@class, 'dataRow')]")
	List<WebElement> dataRows;

	@FindBy(xpath = "//a[normalize-space()='Create New View']")
	WebElement createNewViewLink;

	@FindBy(xpath = "//input[@id='fname']")
	WebElement viewName;

	@FindBy(xpath = "//input[@id='devname']")
	WebElement viewUniquename;

	@FindBy(xpath = "(//input[@title='Save'])[1]")
	WebElement SaveBtn;

	@FindBy(xpath = "//*[contains(@id, 'listSelect')]")
	WebElement viewUserDropDown;

	@FindBy(xpath = "//select[@title='Display Selection']")
	WebElement dropDownBox;

	@FindBy(xpath = "//input[@title='Go!']")
	WebElement GoBtn;

	@FindBy(xpath = "//select[@name='fcf']")
	WebElement viewDropDown;

	@FindBy(xpath = "//*[contains(class,'datarow')]")
	List<WebElement> dataRow;

	@FindBy(xpath = "//*[@id='contentWrapper']/div[2]")
	WebElement pagevalidation;

	@FindBy(xpath = "(//*[@class='errorMsg'])[1]")
	WebElement errorMsg;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]")
	WebElement cancelBtn;

	@FindBy(xpath = "//*[@id='contentWrapper']/div[2]")
	WebElement validationcontactHomePage;

	@FindBy(xpath = "//*[@id='topButtonRow']/input[2]")
	WebElement SaveandnewBtn;

	@FindBy(xpath = "//*[@id='resultsFrame']")
	WebElement resultsFrame;

	@FindBy(xpath = "//*//*[@id='sidebarDiv']/div[2]")
	WebElement ValidateContact;

	@FindBy(xpath = "//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	WebElement contactPageValidation;

	public ContactMenu(WebDriver webDriver) {
		super(webDriver);
		System.out.println("Constructor Sub");
	}

	// Page Object IIB
	{
		elementMap = new HashMap<String, WebElement>();
		elementMap.put("SaveandnewBtn", SaveandnewBtn);
		elementMap.put("newBtn", newBtn);
		elementMap.put("lastNameBox", lastNameBox);
		elementMap.put("GoBtn", GoBtn);
	}

	public void Accname(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(AccnameLookup));
		AccnameLookup.click();
		Set<String> allWindows = driver.getWindowHandles();
		String currentwindow = driver.getWindowHandle();

		for (String window : allWindows) {
			if (!window.equals(currentwindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		driver.switchTo().frame(resultsFrame);
		wait.until(ExpectedConditions.visibilityOfAllElements(dataRows));
		for (WebElement dataRow : dataRows) {
			WebElement accname = dataRow.findElement(By.xpath("./th/a"));
			if (name.equals(accname.getText())) {
				accname.click();
				break;
			}

		}
		driver.switchTo().window(currentwindow);
	}

	public void clickCreatenewview(String viewname, String Uniquename) {
		wait.until(ExpectedConditions.elementToBeClickable(createNewViewLink));
		createNewViewLink.click();
		wait.until(ExpectedConditions.visibilityOf(viewName));
		viewName.sendKeys(viewname);
		wait.until(ExpectedConditions.visibilityOf(viewUniquename));
		viewUniquename.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		viewUniquename.sendKeys(Uniquename);
		wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
		SaveBtn.click();

	}

	public void clickCreatenewview(String Uniquename) {
		wait.until(ExpectedConditions.elementToBeClickable(createNewViewLink));
		createNewViewLink.click();
		wait.until(ExpectedConditions.visibilityOf(viewUniquename));
		viewUniquename.sendKeys(Uniquename);
		wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
		SaveBtn.click();

	}

	public String contactSelectValidation() {
		wait.until(ExpectedConditions.elementToBeClickable(viewUserDropDown));
		Select select = new Select(viewUserDropDown);
		return select.getFirstSelectedOption().getText();
	}

	public void clickdropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownBox));
		dropDownBox.click();
		CommonUtils.selectValues(dropDownBox, "Recently Created");
	}

	public String getFirstOption() {
		Select select = new Select(dropDownBox);
		return select.getFirstSelectedOption().getText();
	}

	public void clickViewDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(viewDropDown));
		viewDropDown.click();
		CommonUtils.selectValues(viewDropDown, "My Contacts");
	}

	public String getOption() {
		wait.until(ExpectedConditions.visibilityOf(viewDropDown));
		Select select = new Select(viewDropDown);
		return select.getFirstSelectedOption().getText();

	}

	public void selectuser(String username) {
		for (WebElement dataRow : dataRows) {
			WebElement userelement = dataRow.findElement(By.xpath("./th/a"));
			System.out.println(userelement.getText());
			if (userelement.getText().equals(username)) {
				userelement.click();
				break;
			}
		}
	}

	public void userselectvalidation() {
		if (pagevalidation.getText().contains("user7 Test7")) {
			System.out.println("Page validated");
		} else {
			System.out.println("Page not validated");
		}
	}

	public void printErrorMsg() {
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		String errormessage = errorMsg.getText();
		if (errormessage.equals("Error: You must enter a value")) {
			System.out.println("The error message is: " + errormessage);
		}
	}

	public void createnewviewpage(String viewname, String Uniquename) {
		wait.until(ExpectedConditions.elementToBeClickable(createNewViewLink));
		createNewViewLink.click();
		wait.until(ExpectedConditions.visibilityOf(viewName));
		viewName.sendKeys(viewname);
		wait.until(ExpectedConditions.visibilityOf(viewUniquename));
		viewUniquename.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		viewUniquename.sendKeys(Uniquename);
		wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		cancelBtn.click();
	}

	public void contacthomepagevalidation() {
		if (validationcontactHomePage.getText().contains("Contacts")) {
			System.out.println("Page validated");
		} else {
			System.out.println("Page not validated");
		}

	}

	public void cicksaveandnewbtn() {
		wait.until(ExpectedConditions.elementToBeClickable(SaveandnewBtn));
		SaveandnewBtn.click();

	}

	public void validatecontact() {
		if (ValidateContact.getText().contains("Global Media")) {
			System.out.println("Contact addded");
		}
	}

	public void pagevalidation() {
		if (contactPageValidation.getText().contains("New Contact")) {
			System.out.println("Page validated");
		}
	}

}
