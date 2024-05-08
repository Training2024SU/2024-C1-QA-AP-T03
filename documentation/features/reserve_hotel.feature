Feature: Hotel Reservation on Despegar.com
  As a user of despegar.com
  I want to reserve a hotel
  So that I can sleep happy

  Scenario Outline: Successfully reserve a hotel
    Given the User is on despegar.com using <webBrowser>
    When navigates to hotel page
    And selects a hotel ubicated on <toDestiny>
    And departs on <fromDate> returning on <toDate> for <nPassengers> passengers
    And confirms the chosen hotel details
    And confirms their personal information
    Then should receive a confirmation message
    Examples:
      | webBrowser | toDestiny     | fromDate   | toDate     | nPassengers |
      | "CHROME"   | "Cancun" | 2024-07-15 | 2024-07-25 | 3           |




