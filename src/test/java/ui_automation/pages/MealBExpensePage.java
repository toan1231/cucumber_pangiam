package ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import ui_automation.utilities.Driver;
import ui_automation.utilities.WaitHelper;

import java.util.List;

public class MealBExpensePage {

    WebDriver driver;
    public MealBExpensePage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = "[href='/Expenses']")
    public WebElement expenseTab;

    @FindBy(css="#expenses-table_wrapper button.add-expense-button")
    public WebElement addExpenseButton;

    @FindBy(xpath = "(//a[text()='Meal & Entertainment'])[2]")
    public WebElement addMealAndEntOption;

    @FindBy(id="ExpenseDateTime")
    public WebElement modalDatePicker;

    @FindBy(css = "#ExpenseDateTime_root .picker__button--today")
    public WebElement modalTodayButton;

    @FindBy(id="Amount")
    public WebElement modalAmountInput;

    @FindBy(id="name")
    public WebElement modalExpenseNameInput;

    @FindBy(xpath = "//button[@title='Select expense relationship']")
    public WebElement modalExpenseRelationshipBtn;

    @FindBy(css = "select#ExpenseRelationshipId")
    public WebElement getModalExpenseRelationshipDrp;

    @FindBy(id="BusinessPurpose")
    public WebElement modalBusinessPurpose;

    @FindBy(id="Company")
    public WebElement modalCompany;

    @FindBy(id="ProjectName")
    public WebElement modalProjectName;

    @FindBy(id="ReceiptFile")
    public WebElement modalAttachmentButton;

    @FindBy(css = ".save-button")
    public WebElement modalSaveButton;

    @FindBy(xpath = "//table[@id='expenses-table']/tbody/tr/td[2]")
    public List<WebElement> lisOfExpenseNames;


    @FindBy(id = "expenses-table_info")
    public WebElement expenseCount;
    public void addMealAndEntExpense(double amount, String exepenseName, String businessRelationshipOption,
                                     String businessPurpose, String company, String projectName ) throws InterruptedException {
        WaitHelper.waitForClickablility(modalDatePicker, 2);
        modalDatePicker.click();
        WaitHelper.waitForClickablility(modalTodayButton, 3);
        modalTodayButton.click();
        modalAmountInput.sendKeys(String.valueOf(amount));
        modalExpenseNameInput.sendKeys(exepenseName);
        modalExpenseRelationshipBtn.click();
        Select businessRelationshipSelObj = new Select(getModalExpenseRelationshipDrp);
        businessRelationshipSelObj.selectByVisibleText(businessRelationshipOption);
        modalBusinessPurpose.sendKeys(businessPurpose);
        modalCompany.sendKeys(company);
        modalProjectName.sendKeys(projectName);
    }

    public String getExpenseTableData(int rowNum, int colNum){
        String tableData = Driver.getInstance().getDriver().
                findElement(By.xpath("//table[@id='expenses-table']/tbody/tr["+rowNum+"]/td["+colNum+"]")).getText();
        return tableData;
    }


}