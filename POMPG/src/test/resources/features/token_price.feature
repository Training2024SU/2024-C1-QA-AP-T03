Feature: Token Price Retrieval
  As a user of the application
  I want to retrieve token prices from a specific network address
  So that I can monitor token prices

  Background:
    Given the CoinGecko API is online

  @RetrieveTokenPrice
  Scenario: Retrieve token price for a specific network address
    When a GET request is made to "https://pro-api.coingecko.com/api/v3/onchain/simple/networks/network/token_price/addresses"
    Then the response status code should be 200
    And the response should contain the token price for a specific address
