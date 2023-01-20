package ui_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.KeyHomePage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

public class testingtesting {
        WebDriver driver= Driver.getInstance().getDriver();
    KeyHomePage keyHomePage=new KeyHomePage();
    Actions actions=new Actions(driver);
    @Given("user navigates to  application")
    public void user_navigates_to_application() {
        driver.get("https://jqueryui.com/tooltip/");
   WebElement st=driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[4]/a"));
        System.out.println( st.getAttribute("href"));
    }


    @Then("user press any {string} on keyboard and user could see the {string}")
    public void user_press_any_on_keyboard_and_user_could_see_the(String string, String string2) throws InterruptedException {
    actions.moveToElement(keyHomePage.keyBox).sendKeys(string).perform();

        String ExpectText=string2;
       String actualResultText= keyHomePage.textShown.getText();
        Assert.assertEquals(ExpectText,actualResultText);
    }
}
