
Feature: Verifying MealB Expense Functionality


  Scenario: User should be able to create an expense
    Given user navigates to MealB login page
    Then user logs in with valid credentials
    Then user clicks on Expense Tab
    Then user clicks on Add Expense button
    Then user selects Meal and Entertainment option
    And user fills out all fields on Meal and Entertainment modal window
    And user clicks on save button
    Then user verifies that newly created expense shows up on expense table
