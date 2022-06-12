Feature: User login

  Background: navigate
    Given Navigate to Woundpros login page

  Scenario: valide login test
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"






