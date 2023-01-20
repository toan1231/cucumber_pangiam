package ui_automation.step_definitions;//package ui_automation.step_definitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import ui_automation.pages.KeyHomePage;
//import ui_automation.utilities.ConfigurationReader;
//import ui_automation.utilities.Driver;
//
//public class KeyBoardFunctionality {
//    WebDriver driver= Driver.getInstance().getDriver();
//    KeyHomePage keyHomePage=new KeyHomePage();
//    Actions actions=new Actions(driver);
//    @Given("user navigates to  application")
//    public void user_navigates_to_application() {
//   driver.get(ConfigurationReader.getProperty("ui-config.properties","key.key.url"));
//    }
//
//    @When("user press any {string} on keyboard")
//    public void user_press_any_on_keyboard(String string) throws InterruptedException {
//    actions.moveToElement(keyHomePage.keyBox).click();
//    actions.moveToElement(keyHomePage.keyBox).keyDown(string);
//        String actualText=textMessage;
//        System.out.println(actualText);
//        Thread.sleep(5000);
//
//    }
//
//
//
//
//    }
//
//}




