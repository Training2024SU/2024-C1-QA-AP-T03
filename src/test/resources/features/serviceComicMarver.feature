Feature: Consultar cómics en la API de Marvel
  Como fanático de los cómics
  Quiero buscar información sobre los cómics de Marvel
  Para descubrir nuevas historias y disfrutar del universo de Marvel

  #autor: Daniel Chaparro

  Background:
    Given que el usuario tiene acceso a la API Marvel

  @service
  @getComic
  Scenario: Consultar un cómic existente con ISBN por ID
    When realiza una solicitud GET para buscar el cómic con el ID 1405
    Then la respuesta debería tener un código de estado 200
    And la respuesta debería incluir la información correcta del comic con título "DAREDEVIL VISIONARIES: FRANK MILLER VOL. 1 TPB (Trade Paperback)" y ID 1405
    And la respuesta debería tener un codigo ISBN "978-0-7851-0757-6" asociado