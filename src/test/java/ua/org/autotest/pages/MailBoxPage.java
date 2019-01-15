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

    @FindBy(xpath = "//*[@id=\"gb\"]/div[2]/div[6]/div[1]/div/div[2]")
    private WebElement userProfile;

    @FindBy(xpath = "//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a/span")
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
