Feature: Verify hover-over functionality

  Background:
    Given user navigates to AP application

#  @apWomensTab
  Scenario: As a user I can hover over women's section and get to casual dresses page
    Then I hover over womens tab
    And I click on casual dresses link
    Then I am navigated to casual dresses page