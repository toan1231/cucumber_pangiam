package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class ApApplicationHomePage {

   WebDriver driver;

   public ApApplicationHomePage() {
      driver = Driver.getInstance().getDriver();
      PageFactory.initElements(driver, this);
   }


   @FindBy(xpath = "")
   public WebElement womensTab;

   @FindBy(xpath = "")
   public WebElement casualDressesLink;

   @FindBy(xpath = "")
   public WebElement casualDressesPageHeader;
}

