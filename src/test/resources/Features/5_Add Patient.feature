Feature: Verify the process of adding a patient

  Background: Navigate to login page and login
    Given Navigate to Woundpros login page
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"

  @AddPatient @AddPatientCard @sanity @registration
  Scenario: Validate add patient test
    Given User clicks on patient menu from dashboard
    Then User clicks add patient button
    Then Enters patient first name
    Then Enters patient last name
    Then Enters patient date of birth as "09-29-2000"
    Then Select patient gender as "Male"
    Then Enters SSN number
    Then Enters patient email
    Then Enters patient phone number
    Then Selects Facility
    Then Enters patient date can bill
    Then Enters patient address as "114 North Eastwood Street, Houston, Texas 77011, United States"
    Then Clicks create
    Then Verify success message alert "added successfully"
    Then Verify added patient populates in table