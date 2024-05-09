@web
Feature: Flights

  Background: Browser
    # The configured browsers are CHROME and FIREFOX
    Given the User browses the internet using the "CHROME" browser

  Scenario: See flight offer info
    Given The user is in the home page
    When he selects one destination from the offers
    Then he should be able to see the flights available with their starting price

  Scenario: See flight clases
    Given The user is looking at the flights available for a destination
    When he selects one flight to see its details
    Then he should be able to see its available classes and prices

  Scenario Outline: Create tickets order
    Given The user is looking at the flights available for a destination
    And he sets the amount of passengers to <quantity>
    When he selects one flight with any type of class
    And he chooses the <quantity> seats from the available ones
    Then he should see the payment summary for the tickets
    Examples:
      | quantity |
      | 2        |

  @critical_path
  Scenario: Buy flight tickets
    Given The user is in the home page
    When he configures a flight filling all the information
    And he completes the payment process
    Then he should get a confirmation of the purchase