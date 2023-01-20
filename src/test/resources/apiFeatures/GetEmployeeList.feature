#Feature: Get User List from Gorest API
#
#
#@FirstTest  @ApiRegression
#Scenario:
#Given User gets Employee List from Gorest API
#Then  Validate if status code is 200
#
#
#@SecondTest   @ApiRegression
#Scenario: Get unique user name from Gorest API
#Given User gets Employee List from Gorest API
#Then User retrieve and print unique Gorest user names
#
#
#@ThirdTest @3  @ApiRegression
#Scenario: Get only Male users
#Given User gets Employee List from Gorest API
#Then Find the first names whose gender is male
Feature:
  @my
  Scenario: Verification of GetExpense API
    Given User submits GET request to GetExpense API
    Then User get the total amount of all otherExpenses and validate against the value from Dashboard API
    And User gets the total amount of all travelExpenses and validate against the value from Dashboard API
    And User gets the total amount of all giftExpenses  and validate against the value from Dashboard API


