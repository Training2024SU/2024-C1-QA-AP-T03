Feature: Formulario de registro
  Yo, como usuario sin registrar en la pagina zona fit
  quiero llenar el formulario de registro
  para poder ingresar y obtener los beneficios de la página

#Usar 1 para navegador Chrome y 2 para Edge
#Escenario 1 es ruta critica

  Background:
    Given que el usuario selecciona el navegador 1 e ingresa a la pagina principal

  @todos
  @rutacritica
  @testcorrecto
  Scenario: Inscripcion correcta
    When ingresa su informacion correctamente
    Then deberia ser redirigido a la pagina principal con la sesion iniciada

  @todos
  @testregistroincorrecto
  Scenario: Intento de registro con el campo de correo vacio
      When intenta registrarse con el campo de correo vacio
      Then deberia visualizar un mensaje de error

  @todos
  @testregistroincorrecto
  Scenario: Intento de registro con cuenta existente
    When ingresa sus datos correctamente pero ya esta registrado
    Then deberia visualizar un mensaje de error indicando que ya hay una cuenta registrada