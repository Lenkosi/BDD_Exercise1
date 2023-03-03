Feature: Search Itinerary
  A feature to search Itinerary

  Background:Login successful
    Given a user is on the home page
    When  a user navigates to the Login page
    And a user enter username and password
    And a user clicks the login button


  Scenario: A successful Search

    When user searches for the desired hotel
    And user enter "Khwezi " , "Myeni " , "Parks ", "4789989665623213" , "VISA ",  "123"
    And a user copy an order ID and Paste at the search bar
    And a user clicks the go button
    Then Results of search shows

