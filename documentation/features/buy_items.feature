Feature: Purchase items on exito.com platform
  As a user of the exito.com platform
  I want to buy various items
  So that I can enjoy and use them

  Scenario Outline: Successfully purchase items
    Given the user is on the exito.com platform using "<webBrowser>"
    When adds the following items to the cart
      | Iphone 13     |
      | PlayStation 5 |
      | Bicicleta     |
      | Xbox one      |
    And confirms their credentials
      | idNumber   | email   | name   | lastname   | phoneNumber   | number   | neighborhood   | building   | mainAddress   |
      | <idNumber> | <email> | <name> | <lastname> | <phoneNumber> | <number> | <neighborhood> | <building> | <mainAddress> |
    Then should receive a confirmation message indicating a successful purchase
    Examples:
      | webBrowser | idNumber   | email                | name  | lastname  | phoneNumber | number  | neighborhood | building | mainAddress |
      | EDGE       | 1012322895 | jorge12@example.com | Jorge David | rodriguez | 3125799229  | 123ASC1 | brasilia     | casa     | F3A         |

