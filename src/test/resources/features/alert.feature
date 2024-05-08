Feature: Alertas
  yo como usario de la aplicación demoga
  quiero alertas de mis acciones
  para asi visualizar el resultado de las operaciones de interes
  #autor: Daniel Chaparro


# escenarios

  Background:
    Given que el usuario esta en la página de alertas

  @testAlerta1
  Scenario: usuarios alertado
    When el usuario realiza acciones que generan alertas
    Then el sistema debería alertar al usuario