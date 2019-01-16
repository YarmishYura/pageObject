package ua.org.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public MailBoxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    @FindBy(xpath = "//div[contains(@aria-label,'Информация об аккаунте')]/div[1]/div[1]/div[2]")
    private WebElement userProfile;

    @FindBy(xpath = "//a[contains(@aria-label,'yarmish.yura12345@gmail.com')]/span")
    private WebElement userMenu;

    @FindBy(id = "gb_71")
    private WebElement buttonLogout;

    public String getUserMail(){
        String userMail = userProfile.getText();
        return userMail;
    }

    public void entryMenu(){
        userMenu.click();
    }

    public void userLogout(){
        buttonLogout.click();
    }
}
