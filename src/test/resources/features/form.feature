Feature: Formulario de incripcion
  yo como usario de la aplicación demoga
  quiero llenar el formulario de incripcion
  para obtener los beneficios de la pagina
  #autor: Daniel Chaparro


# escenarios

  Background:
    Given que el usuario esta en la pagina de registro

  @test1
  Scenario: inscripción correcta
    When ingresa su informacion correctamente
    And envia el formulario
    Then deberia observar un mensaje de registro exitoso