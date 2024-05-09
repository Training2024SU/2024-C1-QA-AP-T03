Feature: Buying Luggage on Latam Airlines

  As a traveler,
  I want to purchase luggage during my flight booking on the Latam Airlines website,
  So that I can efficiently plan my travel and include baggage requirements.

  Background:
    Given I am initiating a flight booking and a luggage purchase 2 "https://www.latamairlines.com/co/es"

  @PurchaseLuggage
  @CriticalPath
  Scenario Outline: Purchase luggage during the purchase process
    When the user looking for a  flight from "<origin>" to "<destination>"
    And choose a flight
    When the user adds luggage to the booking
    Then they should see the cost of the selected luggage

    Examples:
      | origin    | destination |
      | Cali | Bogota      |


