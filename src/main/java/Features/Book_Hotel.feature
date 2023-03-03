Feature: Book a hotel

  Background:Login successful
    Given a user is on the home page
    When  a user navigates to the Login page
    And a user enter username and password
    And a user clicks the login button

  Scenario Outline: Search Successful
#    Given user is on book a hotel page
    When user searches for the desired hotel
    And user enter "<First Name>" , "<Last Name>" , "<Billing Address>", "<Credit card number>" , "<Credit card type>",  "<Cvv number>"
    Then hotel booked successfully

    Examples:
      |First Name| Last Name| Billing Address| Credit card number| Credit card type | Cvv number|
      |Khwezi     |Myeni    | Parks    |4789989665623213  |VISA             |123    |


  Scenario Outline: Search Unsuccessful
#    Given user is on book a hotel page
    When user searches for the desired hotel
    And user enter "<First Name>" , "<Last Name>" , "<Billing Address>", "<Credit card number>" , "<Credit card type>",  "<Cvv number>"
    Then hotel booked unsuccessfully

    Examples:
      |First Name| Last Name| Billing Address| Credit card number| Credit card type | Cvv number|
      |Wow    |Ziyakhala    |parks    |458996 |VIS            |966     |
