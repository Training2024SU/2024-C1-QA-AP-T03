Feature: Flight Reservation on Despegar.com
  As a user of despegar.com
  I want to reserve flights
  So that I can plan and enjoy my travel efficiently

  Scenario Outline: Successfully reserve a flight
    Given the User is on despegar.com using <webBrowser>
    When navigates to fly page
    And selects a flight from <fromDestiny> to <toDestiny>
    And departs on <fromDate> returning on <toDate> for <nPassengers> passengers
    And confirms flight details
    Then should receive a confirmation message
    Examples:
      | webBrowser | fromDestiny | toDestiny     | fromDate   | toDate     | nPassengers |
      | "CHROME"   | "Bogota "   | "Santa marta" | 2024-6-15  | 2024-11-25 | 3           |
      | "CHROME"   | "Medellin " | "Cartagena"   | 2024-7-12  | 2024-9-25  | 2           |
      | "CHROME"   | "Ibague "   | "Cancun"      | 2024-05-19 | 2024-12-25 | 4           |


