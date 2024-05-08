Feature: Latam Airlines Flight Booking

  As a traveler,
  I want to book a one-way flight on the Latam Airlines website,
  So that I can make travel arrangements efficiently.

  Background:
    Given I am initiating a flight booking process 1 "https://www.latamairlines.com/co/es"

  @PurchaseFlight
  Scenario: Book a one-way flight
    When the user searches for a one-way flight
    And selects a flight
    But does not purchase seats or luggage
    And adds passenger information and confirms it
    Then they should see a message with the details of the purchase

  @ChangeFlight
  Scenario: Change the flight during the purchase process
    When the user searches for a one-way flight
    And changes the flight he choose
    Then they should see the updated flight details

  @PurchaseSeat
  @CriticalPath
  Scenario: Purchase seat during the purchase process
    When the user searches for a one-way flight
    And selects a flight
    When the user selects seat options and chooses a seat
    Then they should see the selected seat reflected in the booking

  @PurchaseLuggage
  @CriticalPath
  Scenario: Purchase luggage during the purchase process
    When the user searches for a one-way flight
    And selects a flight
    When the user adds luggage to the booking
    Then they should see the cost of the selected luggage
