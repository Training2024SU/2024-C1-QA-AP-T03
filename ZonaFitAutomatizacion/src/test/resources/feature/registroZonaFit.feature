Feature: Formulario de registro
  Yo, como usuario de la pagina zona fit
  quiero llenar el formulario de registro
  para obtener los beneficios de la página

#Usar 1 para navegador Chrome y 2 para Edge

  Background:
    Given que el usuario selecciona el navegador 1 e ingresa a la pagina

    @testregistrocorrecto
  Scenario: Inscripcion correcta
    When ingresa su informacion correctamente
    Then deberia ser redirigido a la pagina principal con la sesion iniciada

  @testregistroincorrecto
      When intenta registrarse con un campo vacio
      Then deberia visualizar un mensaje de error