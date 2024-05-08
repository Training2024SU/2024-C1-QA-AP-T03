Feature: Compra completa
  yo como usuario
  quiero realizar una compra en Latam
  para hacer uso de su servicio de transporte

  Scenario:
    Given el usuario se encuentra en la pagina de inicio de Latam
    When busca el vuelo sin seleccionar adicionales
      | origen    | destino   | fecha_salida | fecha_regreso |
      | Lima      | Buenos Aires | 2024-08-1   | 2024-10-1    |
    And diligencia el formulario de los pasajeros
      | nombre    | apellido   | fecha_nacimiento | sexo | nacionalidad | tipo_doc | no_doc     | email             | codigo  | numero     |
      | Pedro     | Navaja     | 1998-08-1        | M    | Colombia     | Cedula   | 1023546897 | carlos@gmail.com  | 57      | 3154568956 |
    And inserta su metodo de pago
    Then deberia recibir el mensaje de que su reserva fue completada la información respectiva

