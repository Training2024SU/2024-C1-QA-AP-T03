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
      | webBrowser | fromDestiny | toDestiny     | fromDate   | toDate     | nPassengers |
      | "CHROME"   | "Bogota"    | "Santa marta" | 2024-07-15 | 2024-07-25 | 3           |

      #| "EDGE"     | "Bogota"    | "Santa marta" | 2024-07-15 | 2024-07-25 | 3           |
      #| "EDGE"     | "Medellin"  | "Cancun"      | 2024-05-19 | 2024-07-25 | 4           |
      #| "EDGE"     | "Ibague"  | "New York"      | 2024-05-19 | 2024-07-25 | 4           |



