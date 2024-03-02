@searchproduct
Feature: Search Product Module API Automation

  Scenario Outline: Verify User search product through API
    Given User add Headers for to search Product
    When User add Request Body for "<searchProduct>"
    When User send "POST" request for search Product
    Then User should verify the status code is 200
    And User should verify the search Product response message matches "OK"

    Examples: 
      | searchProduct |
      | nuts          |
