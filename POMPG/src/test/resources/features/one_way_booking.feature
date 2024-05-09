Feature:  Latam Airlines One-Way Flight Booking

  As a traveler,
  I want to book a one-way flight on the Latam Airlines website,
  So that I can efficiently plan my travel.

  Background:
    Given I am initiating a flight booking process 2 "https://www.latamairlines.com/co/es"

  @Oneway
  Scenario Outline: Book a one-way flight from one city to another
    When the user searches for a one-way flight from "<origin>" to "<destination>"
    And selects a flight
    But does not purchase seats or luggage
    And adds passenger information and confirms it
    Then they should see a message with the details of the purchase

    Examples:
      | origin    | destination |
      | Medellin  | Bogota      |
      | Cali      | Pereira    |
      | Barranquilla | Valledupar |
