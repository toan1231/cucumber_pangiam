package ui_automation.step_definitions;
//cai nay thu thoi 08/01
import groovyjarjarantlr4.v4.runtime.misc.MultiMap;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui_automation.utilities.AlertHelper;
import ui_automation.utilities.Driver;
import ui_automation.utilities.GenericHelper;
import ui_automation.utilities.Helper;

import java.util.*;

public class AmazonStepDef {
    WebDriver driver= Driver.getInstance().getDriver();
    @Given("I am at amazon website")
    public void i_am_at_amazon_website() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        System.out.println("hellow world");
        System.out.println("testing july 23");
        //   WebElement interact=Driver.getInstance().getDriver().findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]"));
//      Helper helper=new Helper();
//      helper.jSClick(interact);

    }


    @Then("I cick on all menu item")
    public void iCickOnAllMenuItem(List<String>expectedMenuList) {
        System.out.println("hellow");
        int a=1;
        List<WebElement>actualMenuList=driver.findElements(By.xpath("//*[@id='nav-xshop']/a"));
        for(String eachExpectedMenuList: expectedMenuList){
           String actualMenuListItem= actualMenuList.get(a).getText();
            Assert.assertEquals(eachExpectedMenuList,actualMenuListItem);
            a++;
            System.out.println(actualMenuListItem);
            GenericHelper genericHelper=new GenericHelper();

        }

    }
}
