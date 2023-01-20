package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

public class MealBLoginPage {

    WebDriver driver;
    public MealBLoginPage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="usernameOrEmailAddress")
    public WebElement usernameInputBox;

    @FindBy(name="Password")
    public WebElement passwordInputBox;

    @FindBy(id="LoginButton")
    public WebElement loginButton;



    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }






}
