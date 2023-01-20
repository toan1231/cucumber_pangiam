package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class HoverTextBoxHomePage {
    WebDriver driver;
 public  HoverTextBoxHomePage(){
    driver= Driver.getInstance().getDriver();
    PageFactory.initElements(driver,this);



}


@FindBy(xpath = "//*[@id=\"age\"]")
    public WebElement textBoxHover;
}
