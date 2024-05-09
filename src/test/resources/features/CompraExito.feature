Feature: Compra de producto en Éxito Online

  Background:
    Given que el usuario está en la página de inicio del Éxito desde el navegador "Edge"

    @RutaCritica
    @compraPromocion
  Scenario: Comprar un producto en promoción con envío a un almacén
    When el usuario elige un producto en promoción y lo agrega al carrito
    And el usuario indica la cantidad del producto y llena formulario de informacion personal
    And selecciona la opción de envío "Reclamar en almacén"
    And completa la información de pago
    Then se debería mostrar un mensaje de confirmación de la compra