Feature:  Changing Flights During Purchase Process

  As a traveler,
  I want to change my selected one-way flight during the purchase process on the Latam Airlines website,
  So that I can update my travel arrangements efficiently.


  Background:
    Given I am initiating a flight booking process for a oneway 2 "https://www.latamairlines.com/co/es"

  @ChangeFlight
  @CriticalPath
  Scenario Outline: Change the flight during the purchase process
    When the user searches for a one-way flight available from "<origin>" to "<destination>"
    And selects a new flight
    Then they should see the updated flight details

    Examples:
      | origin    | destination |
      | Barranquilla  | Bogota  |

