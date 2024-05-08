@web
Feature: Flights

  Scenario: See flight offer info
    Given The user is in the home page
    When he selects one destination from the offers
    Then he should be able to see the flights available with their starting price
