Feature: Verify the process of adding a facility

  Background: Navigate to login page and login
    Given Navigate to Woundpros login page
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"

  @addFacility @addFacilityDocument @sanity @registration
  Scenario: Validate add facility test
    Given User clicks on facility menu from dashboard
    Then User clicks add facility button
    Then Enters Sales manager name
    Then Enters facility name
    Then Enters contact person
    Then Select facility type as "Hospice Care"
    Then Click add facility document
    Then Enter document title and document type as "Document"
    Then Selects facility document
    Then Verify success message alert "Document added successfully"
    Then Enters facility address as "114 North Eastwood Street, Houston, Texas 77011, United States"
    Then Enters facility primary email
    Then Enters facility primary phone number
    Then Clicks create to add facility
    Then Verify success message alert "Facility created"
    Then Verify added facility populates in table