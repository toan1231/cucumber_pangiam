package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class OrangeHomepage {
    WebDriver driver;
    public OrangeHomepage (){
         driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver,this);


    }
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimButton;
    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListButton;
    @FindBy(id="btnAdd")
    public WebElement addButton;

}
