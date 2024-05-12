#Autor: Andreina Iglesias

Feature: Formulario de acceso
  Yo, como usuario registrado en la pagina zona fit
  quiero llenar el formulario de acceso
  para acceder a la pagina y adquirir sus beneficios

#Usar 1 para navegador Chrome y 2 para Edge

  Background:
    Given que el usuario selecciona el navegador 1 e ingresa a la pagina principal

  @todos
  @rutacritica
  @testingresocorrecto
  Scenario: Acceso correcto
    When ingresa sus datos de usuario registrado, correctamente
    Then deberia ser redirigido a la pagina principal y le debe figurar la sesion iniciada

  @todos
  @testingresoincorrecto
  Scenario: Acceso no exitoso, usuario no registrado
    When ingresa sus datos pero no se ha registrado
    Then deberia visualizar un mensaje de error y no deberia iniciarse su sesion

  @todos
  @testingresoincorrecto
  Scenario: Acceso no exitoso, campo vacio
    When ingresa sus datos pero deja el campo del password vacio
    Then deberia recibir un mensaje de error y no deberia iniciarse su sesion