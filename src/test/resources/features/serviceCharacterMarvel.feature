Feature: Consultar personajes en la API de Marvel
  Como fanático de los cómics y usuario de la Api de marvel
  Quiero buscar información sobre los personajes de Marvel
  Para conocer más sobre ellos y disfrutar de su universo

#autor: Daniel Chaparro

  Background:
    Given que el usuario tiene acceso a la API de Marvel

    @ApiCharacters
  Scenario: Consultar un personaje existente por ID
    When realiza una solicitud GET para buscar el personaje con el ID 1009610
    Then la respuesta debería tener el código de estado 200
    And la respuesta debería incluir la información correcta del personaje con nombre "Spider-Man (Peter Parker)" personaje con ID 1009610
