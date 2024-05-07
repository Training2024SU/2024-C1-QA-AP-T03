Feature: Flight search on Despegar

  i as a user of the Despegar web page
  want to search flights
  to buy tickets successfully

  Scenario Outline: Search for flights with different parameters
    Given the user is in the Despegar homepage
    When performs a flight search with origin "<origin>" destination "<destination>" from <day> "<month>" to <day2> "<month2>" and cantidad de personas <cantidadPersonas>
    Then should see results of available flighs

    Examples:
      | origin   | destination  | day | month | day2 | month2 | cantidadPersonas |
      | Bogotá   | Madrid       | 11  | Mayo  | 17   | Mayo   | 3                |
      | Medellín | Bogotá       | 12  | Junio | 21   | Junio  | 5                |
      | Cali     | Buenos Aires | 13  | Junio | 31   | Junio  | 7                |