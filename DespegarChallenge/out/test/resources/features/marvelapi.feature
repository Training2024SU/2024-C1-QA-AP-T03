Feature: Consult Marvel api
  i as a user of the marvel api
  want to get information about the comics
  to learn about comics details

  Background:
    Given the user has access to marvel API "http://gateway.marvel.com/v1/public"

  @services
  @test1
  Scenario: Consult characters by name
    When makes a GET request to the endpoint "/characters" with parameter "nameStartsWith" equal to "Wolverine"
    Then should have a status code 200
    And the answer contains at least one character with a name "Wolverine"

  @services
  @test2
  Scenario: Consult comics by character
    When make a GET request to the endpoint "/characters/{characterId}/comics" with parameter "characterId" valid character ID 1009268
    Then should get a status code 200
    And the answer contains at least a comic associated with the character

  @test2
  Scenario: Purchase three different products
    And adds to cart refrigerator "Nevera SAMSUNG No Frost Congelador Superior 236 LTS" 3 washing machine "Lavadora HACEB Carga Superior 11 kg" 2 and blender "'Licuadora Clásica Negra OSTER" 3
    When proceeds to finalize the purchase
    Then should see a confirmation message
