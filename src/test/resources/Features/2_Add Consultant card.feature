Feature: Verify the process of adding consultant card details

  Background: Navigate to login page and login
    Given Navigate to Woundpros login page
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"

  @AddConsultant @AddConsultantCard @sanity @registration
  Scenario: Validate add consultant Vehicle details
    Given User clicks on consultant menu from dashboard
    Then Click on newly created consultant
    Then Click + under vehicle details
    Then Select vehicle make as "TOYOTA"
    Then Select vehicle model
    Then Enter vehicle year
    Then Select fuel type
    Then Enter registration number
    Then Click save to add vehicle details
    Then Verify success message alert "Vehicle added successfully"