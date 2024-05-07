Feature: Flight Reservation on Despegar.com
  As a user of despegar.com
  I want to reserve flights
  So that I can plan and enjoy my travel efficiently

  Scenario Outline: Successfully reserve a flight with dynamic data
    Given the User is on despegar.com using <webBrowser>
    When navigates to fly page
    And selects a flight from <fromDestiny> to <toDestiny>
    And departs on <fromDate> returning on <toDate> for <nPassengers> passengers
    And confirms the chosen flight details
    And confirms their personal information
    Then should receive a confirmation message
    Examples:
      | webBrowser | fromDestiny | toDestiny                                | fromDate   | toDate     | nPassengers |
      #| CHROME     | New York    | London    | 2024-06-01 | 2024-06-10 | 1           |
      | "CHROME"   | "Bogota"    | "Cartagena de Indias, Bolívar, Colombia" | 2024-07-15 | 2024-07-25 | 3           |


