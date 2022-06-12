Feature: Verify the process of patient assessment for Biologic Procedure

  Background: Navigate to login page and login
    Given Navigate to Woundpros login page
    When Enter username and Password
    And Click on login button
    Then User should be logged in with success message "Login success"

  @PatientAssessmentBiologic @boom
  Scenario: Validate the process of patient assessment for Biologic procedure
    Given User clicks on patient menu from dashboard
    Then User selects newly created patient
    Given User clicks on newly created appointment
    Then User clicks on start assessment button
    Then Select procedue as "Biologics"
    Then Select wound status as "Improving"
#    Then Select treatment number "Pre-treatment Assessment - Lower Extremity"
    Then Upload image wound
    Then Verify success message alert "Generating Wound Dimensions"
    Then Verify success message alert "Wound Dimensions Generated"
    Then Select wound location
    Then Fill in dimensions that have not been generated
    Then Select wound size as "Medium"
    #steps for biologic
    Then Click on add biologic button
    Then Select biologic "Skye Biologics Woundfix"
    Then Select graft size and enter quantity as "2"
    #end steps for biologic
    Then Select wound Type as "Heel Ulceration"
    Then Select stage as "Stage III"
    Then Select exudate amount as "Moderate"
    Then Select wound side as "Right"
    Then User fills in tissues affected if they have not been generated
    Then Select conservative treatment as "compression therapy"
    Then Select wound duration as "3 months"
    Then Select wound condition as "is improving"
    Then Select response to therapy as "is responding"
    Then Select wound edges as "Distinct"
    Then Select wound bed as "Scarred Tissue"
    Then Enter undermining value as "Healing"
    Then Enter tunneling size as "1.52"
    Then Select tunneling direction as "2 o'clock"
    Then Enter sinus tract as "1.52"
    Then Select exposed structures as "Muscle"
    Then Select periwound color as "Normal ethnic"
    Then Select pain level as "Mild"
    Then Select exudate type as "Sanguineous"
    Then Select epithelialization as "<25%"
    Then Select odor as "Fruity Smell"
    Then Select infection as "Rule out Infection"
    Then Select other interventions as "Family conference"
    Then Select other related factors as "Nutrition"
    Then Enter Referral recommendations as "Good luck"
#    Then Enter treatment filter as "W/ Biologic"
#    Then Add circulation and neurologic status
#    Then Select Comorbidities as "Type 1 Diabetes"
#    Then Add primary care physician as "DR Alfred Livingstone"
    Then Click create assessment button
    Then Verify success message alert "creating Assessment"
    Then Verify success message alert "Assessment created"
    Then Select treatment scenario as "HOME HEALTH Lower extremities with LARGE size ABD PAD"
#    Then Add treatment order item "A6449 Profore Latex Free Bandage System"
    Then Wait until treatment order item is generated "A6446 Bulk Roll Gauze"
    Then Add plan of care as "Pat dry with gauze"
    Then Click select all under plan of care
    Then Click create assessment button
    Then Verify success message alert "Updating Assessment"
    Then Verify success message alert "Assessment updated"




