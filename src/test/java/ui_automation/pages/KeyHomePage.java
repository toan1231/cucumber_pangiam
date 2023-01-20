package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class KeyHomePage {
    WebDriver driver;
    public KeyHomePage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="result")


    public WebElement textShown;
    @FindBy(id="target")
    public WebElement keyBox;
}
