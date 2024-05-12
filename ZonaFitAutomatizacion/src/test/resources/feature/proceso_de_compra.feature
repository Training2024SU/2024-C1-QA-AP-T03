#Autor: Andreina Iglesias

Feature: Realizar pedido
  Yo como usuario de la pagina Zona Fit
  Quiero agregar productos y confirmar la compra
  Para poder adquirir sus productos.

#Usar 1 para navegador Chrome y 2 para Edge

@todos
@rutacritica
@testcorrecto
  Scenario Outline: Realizar pedido sin registrarse correcto
    Given que el usuario selecciona el navegador <navegador> e ingresa a la pagina principal
    And ingresa a la pagina de productos
    When ingresa los <num_productos> primeros productos disponibles al carrito, confirmando los productos seleccionados
    And llena el formulario de facturacion y envio
    Then la pagina de orden completa deberia mostrar el detalle del pedido y mensaje exitoso
   Examples:
      | navegador | num_productos |
      | 1         | 1             |
      | 2         | 3             |


