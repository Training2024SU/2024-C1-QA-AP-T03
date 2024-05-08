Feature: User registration on despegar.com
  As an user on despegar.com
  I want to register
  So that I can enjoy the benefits

  Scenario Outline: Creation Successfully
    Given the User is on despegar.com using <webBrowser>
    When navigates to authentication page
    And enters its data correctly
    And confirm its data
    Then should receive a confirmation message
    And should be logged in
    Examples:
      | webBrowser |
      | "EDGE"     |

  Scenario Outline: Creation Incorrect
    Given the User is on despegar.com using <webBrowser>
    When navigates to authentication page
    And enters its data incorrectly
    And confirm its data
    Then should receive an error messagge
    Examples:
      | webBrowser |
      | "EDGE"     |


