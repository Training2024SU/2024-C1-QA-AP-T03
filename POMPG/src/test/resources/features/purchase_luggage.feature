Feature: Buying luggage

  As a traveler,
  I want to book a one-way flight on the Latam Airlines website,
  So that I can make travel arrangements efficiently.

  Background:
    Given I am initiating a flight booking and a luggage purchase 2 "https://www.latamairlines.com/co/es"

  @PurchaseLuggage
  Scenario: Purchase luggage during the purchase process
    When the user looking for a  flight
    And choose a flight
    When the user adds luggage to the booking
    Then they should see the cost of the selected luggage
