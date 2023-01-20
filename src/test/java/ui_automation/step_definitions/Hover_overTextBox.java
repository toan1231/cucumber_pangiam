package ui_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.HoverTextBoxHomePage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hover_overTextBox {
    WebDriver driver= Driver.getInstance().getDriver();
    Actions actions=new Actions(driver);
   // HoverTextBoxHomePage hoverTextBoxHomePage=new HoverTextBoxHomePage();
//
//
//
//    @Given("user log in https_iqueryit website")
//    public void user_log_in_https_iqueryit_website(){
//       driver.get(ConfigurationReader.getProperty("ui-config.properties","jque.url"));
//     driver.manage().window().maximize();
//     //................
//        //  WebElement object=driver.findElement(By.cssSelector(".demo-frame"));
//        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
//        actions.moveToElement(driver.findElement(By.id("age"))).perform();
//    }
//
//    @When("user hovers over text box")
//    public void user_hovers_over_text_box() throws InterruptedException {
////      //  WebElement object=driver.findElement(By.cssSelector(".demo-frame"));
////        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
////        actions.moveToElement(driver.findElement(By.id("age"))).perform();
//
//
//    }
//
//    @Then("user see tooltip message")
//    public void user_see_tooltip_message() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }

    @Given("user log in https_iqueryit website")
    public void user_log_in_https_iqueryit_website() throws InterruptedException {
      driver.get(ConfigurationReader.getProperty("ui-config.properties","jque.url"));
    driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.id("age"))).perform();
    }

    @When("user hovers over text box and user see tooltip message")
    public void user_hovers_over_text_box_and_user_see_tooltip_message() {
        System.out.println("hellw");

    }


}

