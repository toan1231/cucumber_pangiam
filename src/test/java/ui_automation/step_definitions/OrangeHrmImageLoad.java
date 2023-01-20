package ui_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.AddEmployee;
import ui_automation.pages.OrangeHomepage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

public class OrangeHrmImageLoad {

      WebDriver dr=Driver.getInstance().getDriver();
      OrangeHomepage orangeHomepage=new OrangeHomepage();

      @Given("user log in OrangeHRM website")
    public void user_log_in_OrangeHRM_website() {
     dr.get(ConfigurationReader.getProperty("ui-config.properties","yollhrm.url"));
     dr.findElement(By.id("txtUsername")).sendKeys(ConfigurationReader.getProperty("ui-config.properties","yollhrm.username"));
     dr.findElement(By.id("txtPassword")).sendKeys(ConfigurationReader.getProperty("ui-config.properties","yollhrm.password"));
    dr.findElement(By.id("btnLogin")).click();
    }


    @When("user click on Pim tab")
    public void user_click_on_Pim_tab() {
 orangeHomepage.pimButton.click();
    }

    @When("user click on Employee Tab")
    public void user_click_on_Employee_Tab() {
     orangeHomepage.employeeListButton.click();
    }

    @When("user enter Employee information")
    public void user_enter_Employee_information() {
orangeHomepage.addButton.click();
    }

    @Then("user upload an image for the employee")
    public void user_upload_an_image_for_the_employee() {
        AddEmployee addEmployee=new AddEmployee();
        System.getProperty("user.dir");
        addEmployee.chooseFileButton.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\person.png");



    }
}
