Feature: verify title box
  Background:
    Given user log in https_iqueryit website

  Scenario: verify pop-up title when hovering over textbox
    When user hovers over text box and user see tooltip message
