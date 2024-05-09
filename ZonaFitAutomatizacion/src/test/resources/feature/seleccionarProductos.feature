Feature: Agregar y modificar productos en el carrito en Zona Fit
  Como usuario de Zona Fit
  Quiero seleccionar productos diferentes, modificar las cantidades
  Para adquirir sus productos
#Escenario 1 es ruta critica
# Usar 1 para navegador Chrome y 2 para

  @todos
  @rutacritica
  @seleccionarproducto
  Scenario Outline: Modificar cantidades de productos en el carrito
    Given que el usuario selecciona el navegador <navegador> e ingresa a la pagina principal
    And navega a la pagina de productos
    When ingresa los <num_productos> primeros productos disponibles al carrito
    And modifica la cantidad del producto <producto_modificado> agregandole <cantidad_modificada>
    Then deberia confirmarse los cambios en las cantidades del producto <producto_modificado> es <nueva_cantidad>
    And el precio del carrito de compras deberia reflejar las nuevas cantidades de los productos
    Examples:
      | navegador | num_productos | producto_modificado | cantidad_modificada | nueva_cantidad |
      | 1         | 2             | 1                   | 2                   | 3              |
    #  | 2         | 5             | 3                   | 5                   | 6              |


