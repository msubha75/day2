package Test.salesforce;

import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.service.ExtentService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeSuite;
import pageObjects.AccountsPage;
import pageObjects.AccwithLastActivity;
import pageObjects.AllTabs;
import pageObjects.ContactMenu;
import pageObjects.CreateAccountPage;
import pageObjects.EditPanel;
import pageObjects.HomePage;
import pageObjects.LeadsPage;
import pageObjects.LoginPage;
import pageObjects.MergeAccount;
import pageObjects.MyProfile;
import pageObjects.Opportunities;
import pageObjects.TopMenuPanel;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AccountsPage accountsPage;
    CreateAccountPage createAccountPage;
    TopMenuPanel topMenuPanel;
    AccountsPage accountspage;
    AccwithLastActivity accwithlastactivity;
    Opportunities opportunities;
    MergeAccount mergeAccount;
    LeadsPage leadsPage;
    ContactMenu contactMenu;
    MyProfile myprofile;
    EditPanel editPanel;
    AllTabs alltabs;
    ExtentReports extent;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("Extent Report started");
        extent = ExtentService.getInstance();
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-report/Test Report.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Extent Report published");
        extent.flush(); // Flushes the report to the file
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://login.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        topMenuPanel = new TopMenuPanel(driver);
        accountsPage = new AccountsPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountspage = new AccountsPage(driver);
        accwithlastactivity = new AccwithLastActivity(driver);
        opportunities = new Opportunities(driver);
        mergeAccount = new MergeAccount(driver);
        leadsPage = new LeadsPage(driver);
        contactMenu = new ContactMenu(driver);
        myprofile = new MyProfile(driver);
        editPanel = new EditPanel(driver);
        alltabs = new AllTabs(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
