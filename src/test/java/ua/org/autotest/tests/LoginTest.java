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

public class LoginTest extends SetUpTest {
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
}
