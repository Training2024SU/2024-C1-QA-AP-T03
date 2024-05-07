Feature: Formulario de registro
  Yo, como usuario de la pagina zona fit
  quiero llenar el formulario de registro
  para obtener los beneficios de la página


    @testregistro
  Scenario Outline: Inscripcion correcta
    Given que el usuario selecciona el navegador <navegador> e ingresa a la pagina
    When ingresa su informacion correctamente con su email <email>, password <password>, confirma su password <confirmPassword>
    And envia el registro
    Then deberia ser redirigido a la pagina principal con la sesion iniciada

    Examples:
      | navegador | email                 | password      | confirmPassword |
      | 2         | "usuario@example.com" | "password123" | "password123"   |
      #| 2         | "user@example.com"    | "secret123"   | "secret123"     |
