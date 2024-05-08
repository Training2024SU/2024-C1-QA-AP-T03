Feature: Modificar agregar productos en el carrito en Zona Fit
  Como usuario de Zona Fit
  Quiero seleccionar productos diferentes, modificar las cantidades
  Para adquirir sus productos

  Scenario: Modificar cantidades de productos en el carrito
    Given que el usuario selecciona el navegador 1 e ingresa a la pagina
    When el usuario navega a la pagina de productos
    When el usuario agrega los 2 primeros productos disponibles al carrito
    And el usuario abre el modal del carrito de compras
    And modifica la cantidad del producto 1 agregandole 3
    Then el usuario confirma los cambios en las cantidades del producto 1 es 4
    And el precio del carrito de compras deberia reflejar las nuevas cantidades de los productos
