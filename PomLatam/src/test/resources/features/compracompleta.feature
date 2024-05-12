Feature: Compra completa
  yo como usuario
  quiero realizar una compra en Latam
  para hacer uso de su servicio de transporte

  #El navegador 1 es Microsoft edge y el navegador 2 es google Chrome

  @CompraIdaVuelta
  Scenario:
    Given el usuario se encuentra en la pagina de inicio de Latam en el navegador 2
    When busca el vuelo sin seleccionar adicionales
      | origen    | destino   | fecha_salida | fecha_regreso |
      | Lima      | Buenos Aires | 2024-08-1   | 2024-10-1    |
    And diligencia el formulario de los 1 pasajeros
      | nombre    | apellido   | fecha_nacimiento | sexo | nacionalidad | tipo_doc | no_doc     | email             | codigo  | numero     |
      | Pedro     | Navaja     | 12-08-2000       | Masculino    | Colombia     | Cedula   | 1023546897 | carlos@gmail.com  | 57      | 3154568956 |
    And inserta su metodo de pago
      | numero              | nombre   | fecha   | cvv |
      | 5471300000000003    | Pedrito   | 0727 | 777   |
    Then deberia recibir el mensaje de que su reserva fue completada la información respectiva


