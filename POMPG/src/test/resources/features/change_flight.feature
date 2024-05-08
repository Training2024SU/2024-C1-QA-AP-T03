Feature: Selecting new flights

  As a traveler,
  I want to book a one-way flight on the Latam Airlines website,
  So that I can make travel arrangements efficiently.

  Background:
    Given I am initiating a flight booking process for a oneway 2 "https://www.latamairlines.com/co/es"

  @ChangeFlight
  Scenario: Change the flight during the purchase process
    When the user searches for a one-way flight available
    And selects a new flight
    Then they should see the updated flight details