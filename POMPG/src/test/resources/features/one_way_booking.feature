Feature: Latam Airlines Flight Booking

  As a traveler,
  I want to book a one-way flight on the Latam Airlines website,
  So that I can make travel arrangements efficiently.

  Background:
    Given I am initiating a flight booking process 1 "https://www.latamairlines.com/co/es"

  @Oneway
  Scenario: Book a one-way flight
    When the user searches for a one-way flight
    And selects a flight
    But does not purchase seats or luggage
    And adds passenger information and confirms it
    Then they should see a message with the details of the purchase
