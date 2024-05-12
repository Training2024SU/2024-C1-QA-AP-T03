Feature: Proceso de compra en ZonaFit
  yo como usuario de la tienda ZonaFit
  quiero llenar el formulario de inscripción
  para obtener los beneficios de la página

#Autor: Julio Vasquez
#Todos escenarios son ruta critica

  Background:
    Given que el usuario se encuentra en la pagina de inicio de ZonaFit

  @rutacritica @test1
  Scenario Outline: inicio de sesión exitoso
    Given con el navegador <navegador>
    When ingresa su informacion correctamente de email <email> y contraseña <contrasena>
    And confirma la acción
    Then deberia observar que se inicio sesión
    Examples:
      | navegador | email                 | contrasena   |
      | 1         | "Varobass0@gmail.com" | "Zonafit123" |

  @rutacritica @test2
  Scenario Outline: seleccion de productos
    When selecciona los productos <product1> <product2> <product3>
    Then deberia verse los productos en el carrito
    Examples:
      | product1 | product2 | product3 |
      | 0        | 2        | 4        |

  @rutacritica @test3
  Scenario: confirmar compra
    Given que el usuario va a la página de carrito
    When confirma la compra
    Then deberia aparecer la forma de pago
