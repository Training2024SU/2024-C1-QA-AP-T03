Feature: Flight search on Despegar

  i as a user of the Despegar web page
  want to search flights
  to buy tickets successfully

  Background:
    Given the user is in the Despegar homepage in the 1

  @test1
  Scenario Outline: Search for flights with different parameters
    When performs a flight search with origin "<origin>" destination "<destination>" from <day> "<month>" to <day2> "<month2>" and cantidad de personas <cantidadPersonas>
    And selects the first flight option
    Then should see results of available flights
    #pendiente terminar el then

    Examples:
      | origin                        | destination                         | day | month | day2 | month2 | cantidadPersonas |  |  |
      | Bogotá, Bogotá D.C., Colombia | Madrid, Comunidad de Madrid, España | 11  | 05    | 17   | 05     | 3                |  |  |
      #| Medellín | Bogotá       | 12  | Junio | 21   | Junio  | 5                |  |  |
     # | Cali   | Buenos Aires | 13  | Junio | 31   | Junio  | 7                |  |  |

  @test2
  Scenario: Search for lodging
    When goes to lodging page to perform the search city "Praga, Praga, República Checa" from 15 05 to 25 06 and adults 3
    And selects the first lodging option


