
Feature: Login
A feature to test a login to a application

  Scenario: Login successful
    Given a user is on the home page
    When  a user navigates to the Login page
    And a user enter username and password
    And a user clicks the login button
    Then a user is login in successfully