@State
Feature: State Module API Automation

  Scenario: Verify User Get stateList through API
    Given User add Headers for to stateList
    When User send "GET" request for the stateList
    Then User should verify the status code is 200
    And User should verify the stateList response message matches "Tamil Nadu" and saved stateId
