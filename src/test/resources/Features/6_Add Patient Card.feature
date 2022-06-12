Feature: Verify the process of adding patient card details

  Background: Navigate to login page and login
    Given Navigate to Woundpros login page
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"

  @AddPatient @AddPatientCard @registration
  Scenario: Validate add patient insurance information
    Given User clicks on patient menu from dashboard
    Then Click on newly created patient
    Then Click + under insurance information
    Then Enter Insurance plan as "Jubilee Insurance"
    Then Enter policy number
    Then Enter phone number
    Then Enter fax
    Then Enter copay due
    Then Select priority
    Then Enter contact person name
    Then Save Insurance Information
    Then Verify success message alert "Insurance added successfully"

  @AddPatient @AddPatientCard @registration
  Scenario: Validate add patient additional contacts
    Given User clicks on patient menu from dashboard
    Then Click on newly created patient
    Then Click edit under contact information
    Then Enter patient contact full names
    Then Enter patient contact phone number
    Then Save patient contact information
    Then Verify success message alert "updated successfully"

  @AddPatient @AddPatientCard @registration
  Scenario: Validate add patient shipping address
    Given User clicks on patient menu from dashboard
    Then Click on newly created patient
    Then Click + under shipping address
    Then Enter patient shipping address as "114 North Eastwood Street, Houston, Texas 77011, United States"
    Then Enter patient physical address as "Westlands"
    Then Save patient shipping address
    Then Verify success message alert "added successfully"

  @AddPatient @AddPatientCard @registration
  Scenario: Validate add patient documents
    Given User clicks on patient menu from dashboard
    Then Click on newly created patient
    Then Click patient documents tab
    Then Click + under patient documents
    Then Enter patient document title as "Birth Certificate"
    Then Select patient document type as "Document"
    Then Upload patient document
    Then Click add to add patient document
    Then Verify success message alert "Document added successfully"

  @AddPatient @AddPatientCard @registration
  Scenario: Validate add patient notes
    Given User clicks on patient menu from dashboard
    Then Click on newly created patient
    Then Click patient internal notes tab
    Then Click + under internal notes
    Then Enter patient notes
    Then Click add to add patient notes
    Then Verify success message alert "added successfully"


