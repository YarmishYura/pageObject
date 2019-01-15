package ua.org.autotest.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.org.autotest.pages.LoginPage;
import ua.org.autotest.pages.MailBoxPage;


import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MailBoxPage mailBoxPage;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
    }

    @Test
    public void loginTest(){
        loginPage.inputLogin("yarmish.yura12345@gmail.com");
        loginPage.clickLoginButton();
        loginPage.inputPassword("12345yarmish");
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mailBoxPage.entryMenu();
        String mailUser = mailBoxPage.getUserMail();
        Assert.assertEquals("yarmish.yura12345@gmail.com", mailUser);
    }

    @AfterClass
    public static void tearDown(){
        mailBoxPage.userLogout();
        driver.quit();
    }
}
