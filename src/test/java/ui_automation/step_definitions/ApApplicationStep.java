package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.ApApplicationHomePage;
import ui_automation.utilities.Driver;

public class ApApplicationStep {

    WebDriver driver = Driver.getInstance().getDriver();
    ApApplicationHomePage apApplicationHomePage = new ApApplicationHomePage();
    Actions act = new Actions(driver);

    @Given("user navigates to AP application")
    public void user_navigates_to_AP_application() {
        driver.get("");
        String title = driver.getTitle();

        Assert.assertEquals("Title verification failed for AP applicatin!", "My Store", title);
    }

    @Then("I hover over womens tab")
    public void i_hover_over_womens_tab() {
        act.moveToElement(apApplicationHomePage.womensTab);
    }

    @Then("I click on casual dresses link")
    public void i_click_on_casual_dresses_link() {
        apApplicationHomePage.casualDressesLink.click();
    }

    @Then("I am navigated to casual dresses page")
    public void i_am_navigated_to_casual_dresses_page() {
        String headerOfAPCasualDressesPage = apApplicationHomePage.casualDressesPageHeader.getText();
        Assert.assertEquals("Header verification failed in Casual Dresses Page", "CASUAL DRESSES", headerOfAPCasualDressesPage);
    }
}