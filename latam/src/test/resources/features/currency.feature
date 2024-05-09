@currency
Feature: Currency operations
  As an integration system I
  WANT to make operations with currencies
  SO THAT I can keep prices up to date

  Scenario Outline: Obtain the current price for a cryptocurrency
    When The system asks for the current price of "<crypto>" in "<currency>"
    Then it should get a successful answer with the market price of "<crypto>" in "<currency>"
    Examples:
      | crypto   | currency |
      | bitcoin  | usd      |
      | ethereum | eur      |

  Scenario: Currencies list
    When The system requests the list of supported cryptocurrencies
    Then it should get a successful answer
    And it should receive the complete list of currencies