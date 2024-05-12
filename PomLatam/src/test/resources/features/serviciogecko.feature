Feature: Obtener precio de criptomoneda con CoinGecko
  yo como usuario de la api de Coingecko
  quiero consultar los precios de cripto
  para manejar mis criptos

  @bitcoin
  Scenario: Consultar precio actual de Bitcoin en dolares
    Given el usuario tiene acceso a la api
    When hace una solicitud GET para obtener el precio de bitcoin
    Then la respuesta deberia incluir el precio actual de Bitcoin en dolares estadounidenses

    @ethereum
  Scenario: Consultar precio actual de Ethereum en euros
    Given el usuario tiene acceso a la api
    When hace una solicitud GET para obtener el precio de Ethereum en euros
    Then la respuesta debería incluir el precio actual de Ethereum
      And deberia obtener un codigo de estatus 200







