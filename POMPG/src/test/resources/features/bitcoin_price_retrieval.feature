Feature: Bitcoin Price Retrieval
  As a user of the application
  I want to retrieve the latest price and market data of Bitcoin
  So that I can monitor cryptocurrency market trends

  Background:
    Given the CoinGecko API is online

  @RetrieveBitcoinPrice
  Scenario: Retrieve Bitcoin price and market data
    When a GET request is made to "https://pro-api.coingecko.com/api/v3/simple/price"
    Then the response status code should be 200
    And the response should include the price and related information
