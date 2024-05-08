Feature: Search all heroes using GET service
  As a user of marvel.com
  I want to search for information about all the heroes
  So that I can view their details and enjoy the content


  ## just using the first results as assertions for speed
  Scenario: Search all heroes
    Given the user is connected to the Marvel Developer API
    When sends a GET request to retrieve all heroes
    Then response should contain information about all heroes including
      | A-Bomb (HAS)               |
      | A.I.M.                     |
      | Abomination (Emil Blonsky) |
      | Absorbing Man              |
    And should receive a response of 200

