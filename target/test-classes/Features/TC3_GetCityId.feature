@City
Feature: City Module API Automation

  Scenario: Verify User Get cityList through API
    Given User add header for to get CityList
    When User add request body stateid for get CityList
    Then User Send "POST" request for CityList endpoint
    And User should verify the cityList response message matches "Yarcaud" and saved cityId
