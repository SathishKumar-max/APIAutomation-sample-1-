@Login
Feature: Login Module Api Automation

  Scenario: Get User logtoken from login feature
    Given User add Header
    When User add Basic Authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200
    And User should verify the login response code first_Name present as "Karuna" and get the logtoken saved
