Feature: Formulario de acceso
  Yo, como usuario registrado en la pagina zona fit
  quiero llenar el formulario de acceso
  para acceder a la pagina y adquirir sus beneficios

#Usar 1 para navegador Chrome y 2 para Edge

  Background:
    Given que el usuario selecciona el navegador 1 e ingresa a la pagina

  @testingresocorrecto
  @ingresoexitoso
  Scenario: Acceso correcto
    When ingresa sus datos de usuario registrado, correctamente
    Then deberia ser redirigido a la pagina principal y le debe figurar la sesion iniciada