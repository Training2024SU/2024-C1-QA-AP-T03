Feature: Purchase one or multiple products
  I as user of the webpage ZonaFit
  Want to buy products
  for getting my products delivered to my house

  @test1
  Scenario Outline: Successful purchase without login
    Given the user is in the webpage does not login and goes to the products module
    When Search for the products, add them to the car and go to my car
      | product                                          | amount |
      | Essential Amino Energy 30 serv Optimum Nutrition | 2      |
      | Cuerdas de tension con mochila                   | 1      |
      | Creatine Powder 300 gr Optimum Nutrition         | 1      |
    And increase the amount of objects in the car and confirm the products in the car
    And fill the fields in the car with correct information and confirm the payment method
      | idNumber   | email   | name   | lastName   | state   | city   | address   | address2   | phoneNumber   |
      | <idNumber> | <email> | <name> | <lastName> | <state> | <city> | <address> | <address2> | <phoneNumber> |
    And fill the payment information and confirm them
    Then it should be redirected to another page with a successful purchase
    And it should get a confirmation email
    Examples:
      | idNumber | email           | name  | lastName | state | city   | address     | address2 | phoneNumber |
      | 12346789 | jorge@gmail.com | jorge | jorge    | CUN   | Bogota | av 15#12-23 | casa 5-c | 3195229951  |


