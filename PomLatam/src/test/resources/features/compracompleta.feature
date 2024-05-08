Feature: Compra completa
  yo como usuario
  quiero realizar una compra en Latam
  para hacer uso de su servicio de transporte

  Scenario:
    Given el usuario esta en la pagina de inicio de Latam
    When busca un el vuelo sin seleccionar adicionales
      | origen    | destino   | fecha_salida | fecha_regreso |
      | Lima      | Buenos Aires | 2024-08-1   | 2024-10-1    |
    And diligencia el formulario de los 4 pasajeros
    And inserta su metodo de pago
    Then deberia recibir el mensaje de que su reserva fue completada la información respectiva

