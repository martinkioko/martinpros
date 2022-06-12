Feature: Verify the process of adding a facility documents

  Background: Navigate to login page and login
    Given Navigate to Woundpros login page
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"

  @addFacility @addFacilityDocument @registration
  Scenario: Validate add facility document
    Given User clicks on facility menu from dashboard
    Then Click on newly created facility
    Then Click + under documents
    Then Enter document title as "Business Registration Letter" and select document type as "Document"
    Then Upload facility document
    Then Click add to add facility document
    Then Verify success message alert "Document added successfully"
    Then Verify success message alert "Facility update successful"