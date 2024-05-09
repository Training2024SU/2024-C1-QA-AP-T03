Feature: CoinGecko API Ping Check
  As a user of the application
  I want to perform a ping check to the CoinGecko API
  So that I can verify that the API is responsive

  Background:
    Given the CoinGecko API is online

  @PingCheck
  @Ping
  Scenario: Perform API ping check
    When a GET request is made to "https://api.coingecko.com/api/v3/ping"
    Then the response status code should be 200
    And the response should contain "gecko_says" with value "(V3) To the Moon!"


  @PingCheckIncorrectRequest
  @Ping
  Scenario: Perform API ping check with incorrect request
    When a GET request is made to "https://api.coingecko.com/api/v3/ping-invalid"
    Then the response status code should be 404
