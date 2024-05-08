Feature: Registro, agregar y modificar productos
  Yo como usuario no registrado de la pagina Zona Fit
  Quiero poder registrarme, agregar productos y llenar el formulario de compra
  Para poder adquirir sus productos.

#Usar 1 para navegador Chrome y 2 para Edge

  Scenario Outline: Registro de nuevo usuario, agregar y modificar cantidades del producto en el carrito
    Given que el usuario selecciona el navegador 1 e ingresa a la pagina
    When ingresa su informacion correctamente
    And el usuario navega a la pagina de productos
    When el usuario ingresa los <num_productos> primeros productos disponibles al carrito
    And el usuario abre el modal del carrito de compras
    And modifica la cantidad del producto <producto_modificado> agregandole <cantidad_modificada>
    Then el usuario confirma los cambios en las cantidades del producto <producto_modificado> es <nueva_cantidad>
    And el precio del carrito de compras deberia reflejar las nuevas cantidades de los productos

    Examples:
      | navegador | num_productos | producto_modificado | cantidad_modificada | nueva_cantidad |
      | 1         | 2             | 1                   | 3                   | 4              |
    #  | 2         | 5             | 3                   | 5                   | 6              |