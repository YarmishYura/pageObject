package ua.org.autotest.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.org.autotest.pages.LoginPage;
import ua.org.autotest.pages.MailBoxPage;

import java.util.concurrent.TimeUnit;

public class SetUpTest{
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MailBoxPage mailBoxPage;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    }

    @AfterClass
    public static void tearDown(){
        mailBoxPage.userLogout();
        driver.quit();
    }
}
