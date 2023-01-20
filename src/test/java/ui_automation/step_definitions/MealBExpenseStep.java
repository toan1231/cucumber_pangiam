package ui_automation.step_definitions;

import com.github.javafaker.Faker;
import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import ui_automation.pages.MealBExpensePage;
import ui_automation.pages.MealBLoginPage;
import ui_automation.utilities.*;
import ui_automation.utilities.Driver;

import javax.security.auth.login.Configuration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MealBExpenseStep {

    MealBLoginPage mealBLoginPage = new MealBLoginPage();
    MealBExpensePage mealBExpensePage = new MealBExpensePage();
    private static final Logger oLog = LogManager.getLogger(GenericHelper.class);
    String expenseName;
    double amount;
    String businessRelationshipOption;
    String businessPurpose;
    String companyName;
    String projectName;

    @Given("user navigates to MealB login page")
    public void user_navigates_to_MealB_login_page() {
        Driver.getInstance().getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "mealb.url")+"/Account/Login");
    }

    @Then("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() throws InterruptedException {
        String username = ConfigurationReader.getProperty("ui-config.properties", "mealb.username");
        String password = ConfigurationReader.getProperty("ui-config.properties", "mealb.password");
        mealBLoginPage.login(username, password);
    }

    @Then("user clicks on Add Expense button")
    public void user_clicks_on_Add_Expense_button() {
        mealBExpensePage.addExpenseButton.click();
    }

    @Then("user selects Meal and Entertainment option")
    public void user_selects_Meal_and_Entertainment_option() {
        mealBExpensePage.addMealAndEntOption.click();
    }

    @Then("user fills out all fields on Meal and Entertainment modal window")
    public void user_fills_out_all_fields_on_Meal_and_Entertainment_modal_window() throws Exception {
        String file = System.getProperty("user.dir")+"/src/test/resources/testData/testData.xlsx";
        ExcelUtility.setExcelFile(file, "Sheet1");
        expenseName = String.valueOf(ExcelUtility.getCellData(1,0));
        amount = Double.parseDouble(ExcelUtility.getCellData(1,3).toString());
        businessRelationshipOption = String.valueOf(ExcelUtility.getCellData(1,2));;
        businessPurpose = String.valueOf(ExcelUtility.getCellData(1,4));;
        companyName = String.valueOf(ExcelUtility.getCellData(1,5));;
        projectName=String.valueOf(ExcelUtility.getCellData(1,6));;
        mealBExpensePage.addMealAndEntExpense(amount, expenseName, businessRelationshipOption,businessPurpose ,
                companyName, projectName);
    }

    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {
        mealBExpensePage.modalSaveButton.click();
    }

    @Then("user verifies that newly created expense shows up on expense table")
    public void user_verifies_that_newly_created_expense_shows_up_on_expense_table() {
        //1. Use xpath text locator to make sure the value we created is there
//        WebElement targetElem = Driver.getInstance().getDriver().findElement(By.xpath("//td/a[text()='"+expenseName+"']"));
//        Assert.assertTrue("The expense name is not shown on the table", targetElem.isDisplayed());

        //2. Use loops to find of the occurance of the value
        boolean match=false;
        for(int i=0; i<mealBExpensePage.lisOfExpenseNames.size(); i++) {
            if (mealBExpensePage.lisOfExpenseNames.get(i).getText().equals(expenseName)) {
                match=true;
            }
        }
        Assert.assertTrue("The expense name was not found on the table",match);
    }

    @Then("user clicks on Expense Tab")
    public void userClicksOnExpenseTab() {
        mealBExpensePage.expenseTab.click();
    }

    @Then("print all the data on the excel file")
    public void printAllTheDataOnTheExcelFile() throws Exception {
        String file = System.getProperty("user.dir")+"/src/test/resources/testData/Keywords.xlsx";
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalNumberOfRows = sheet.getPhysicalNumberOfRows();
        int totalNumberOfColumns;


        //outer loop
        for(int i=0; i< totalNumberOfRows; i++){
            //Find out how many columns are there for each row
            totalNumberOfColumns = sheet.getRow(i).getPhysicalNumberOfCells();
            //inner loop
            for(int j=0; j< totalNumberOfColumns; j++){
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
            }
            System.out.println();

        }
    }

    @Then("I can write some data to the excel file")
    public void iCanWriteSomeDataToTheExcelFile() throws Exception {
        String file = System.getProperty("user.dir")+"/src/test/resources/testData/Keywords.xlsx";
        ExcelUtility.setExcelFile(file, "Sheet1");
        ExcelUtility.setCellData(file, "Apple", 7, 1);
    }

    @Then("I fill out all fields on Meal and Entertainment with random data")
    public void iFillOutAllFieldsOnMealAndEntertainmentWithRandomData() throws InterruptedException {
        Faker faker = new Faker();
        expenseName = faker.food().spice();
        amount = faker.number().randomDouble(2, 0, 10000 );
        businessRelationshipOption = "Vendor";
        businessPurpose =faker.funnyName().name();
        companyName = faker.company().name();
        projectName=faker.commerce().productName();
        mealBExpensePage.addMealAndEntExpense(amount, expenseName, businessRelationshipOption,businessPurpose ,
                companyName, projectName);
    }

    @And("user should see previously created expenses by him")
    public void userShouldSeePreviouslyCreatedExpensesByHim() throws ClassNotFoundException, SQLException, InterruptedException {
        //Specify which database we want to connect to
        //Create Connection object to establish connection to the database
        DBUtility.openConnection();

        //Create statement object
        //Send the query to the database
        List<Map<String, Object>> dataFromDb= DBUtility.executeSQLQuery("select Name , Amount, BusinessPurpose , ExpenseDateTime , \n" +
                "ProjectName , ExpenseType \n" +
                "from dbo.Expenses WHERE CreatorUserId =(SELECT UserId  from dbo.AbpUserAccounts aua \n" +
                "where UserName ='Walmart') and DeletionTime is null;");

        System.out.println(dataFromDb.get(0).get("Name"));

        int expenseCountFromDB = dataFromDb.size();
        int expenseCountFromUI;

        WaitHelper.waitForVisibility(mealBExpensePage.expenseCount, 3);
        String expenseCountMsg = mealBExpensePage.expenseCount.getText();
        String[] words = expenseCountMsg.split(" ");//"Showing 1 to 3 of 3 entries"
        expenseCountFromUI = Integer.parseInt(words[5]);
        Assert.assertEquals("The number of expense do not match",expenseCountFromDB, expenseCountFromUI);
    }
}

