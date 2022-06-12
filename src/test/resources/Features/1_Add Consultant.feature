Feature: Verify the process of adding a consultant

  Background: Navigate to login page and login
    Given Navigate to Woundpros login page
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"

  @AddConsultant @AddConsultantCard @sanity @registration
  Scenario: Validate add consultant test
    Given User clicks on consultant menu from dashboard
    Then User clicks add consultant button
    Then Enters consultant first name
    Then Enters consultant last name
    Then Enters consultant date of birth as "09-29-2000"
    Then Select consultant gender as "Male"
    Then Enters consultant date of hire
    Then Enters consultant NPI
    Then Enters consultants CAQH ID
    Then Enters consultants BHPN Practitioner ID
    Then Enters consultant email
    Then Enters consultant phone number
    Then Selects consultant degree as "MBA"
    Then Enters consultant language as "English"
    Then Selects consultant designation as "Consultant"
    And Enters consultant role as "Consultant"
    And Enters consultant role as "RegionalSalesAssociate"
    Then Enters consultant address as "114 North Eastwood Street, Houston, Texas 77011, United States"
    Then Clicks create
    Then Verify success message alert "Consultant created"
    Then Verify added consultant populates in table