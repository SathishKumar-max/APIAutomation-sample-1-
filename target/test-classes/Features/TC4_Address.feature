@Address
Feature: Address Module API Automation

  Scenario Outline: Verify add User address to the application through API
    Given User add Headers and Bearer Authorizatin for accessing address post endpoint
    When User add request body for new address "<first_name>","<last_name>","<mobile>","<apartment>",<state> and <city> and <country>,"<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for adduserAddress endpoint
    Then User should verify the status code is 200
    And User should verify adduserAddress response message matches "Address added successfully" and save address_id

    Examples: 
      | first_name | last_name | mobile      | apartment | state | city | country | zipcode | address                          | address_type |
      | Shivam     | Universe  | 95989302849 | World     |    33 | 3378 |     101 |  202020 | sivan koil street,Tiruvannamalai | Home         |

  Scenario Outline: Verify update address to the application through API
    Given User add Headers and Bearer Authorizatin for accessing address put endpoint
    When User add request body for update address "<address_id>","<first_name>","<last_name>","<mobile>","<apartment>",<state> and <city> and <country>,"<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for UpdateuserAddress endpoint
    Then User should verify the status code is 200
    And User should verify UpdateuserAddress response message matches "Address updated successfully"

    Examples: 
      | address_id | first_name | last_name | mobile      | apartment | state | city | country | zipcode | address                          | address_type |
      |      62342 | Shivam     | Universe  | 95989302849 | World     |   333 |   22 |      33 |  605758 | sivan koil street,Tiruvannamalai | Home         |

  Scenario Outline: Verify get address to the application through API
    Given User add Headers and Bearer Authorizatin for accessing address get endpoint
    When User send "GET" request for getuserAddress endpoint
    Then User should verify the status code is 200
    And User should verify adduserAddress response message matches "OK"

    Examples: 
      | first_name | last_name | mobile      | apartment | state | city | country | zipcode | address                          | address_type |
      | Shivam     | Universe  | 95989302849 | World     |   333 |   22 |      33 |  605758 | sivan koil street,Tiruvannamalai | Home         |

  Scenario Outline: Verify delete address to the application through API
    Given User add Headers and Bearer Authorizatin for accessing address delete endpoint
    When User add request body for delete address "<address_id>"
    And User send "DELETE" request for deleteuserAddress endpoint
    Then User should verify the status code is 200
    And User should verify deleteuserAddress response message matches "Address deleted successfully"

    Examples: 
      | address_id |
      |      66673 |
