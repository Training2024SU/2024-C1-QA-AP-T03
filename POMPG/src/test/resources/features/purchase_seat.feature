Feature: Buying seats

  As a traveler,
  I want to book a one-way flight on the Latam Airlines website,
  So that I can make travel arrangements efficiently.

  Background:
    Given I am initiating a flight booking and a seat purchase 1 "https://www.latamairlines.com/co/es"


  @PurchaseSeat
  @CriticalPath
  Scenario: Purchase seat during the purchase process
    When the user searches for a flight
    And selects it
    When the user selects seat options and chooses a seat
    Then they should see the selected seat reflected in the booking