Feature: Busqueda de vuelo en la página de Latam
  Yo como usuario de la pagina de Latam
  quiero buscar vuelos con mis criterios
  para conocer los que estén disponibles

#autor: Juan José
  @RutaCritica @BuscarVuelosIdaYVuelta
  Scenario Outline:Búsqueda de vuelos con diferentes fechas
    Given el usuario esta en la pagina de inicio de Latam
    When selecciona el origen "<origen>", destino "<destino>", fecha de salida "<fecha_salida>" y fecha de regreso "<fecha_regreso>"
    And selecciona la opcion de buscar
    Then el usuario debería ver una lista de vuelos disponibles
    Examples:
  | origen    | destino   | fecha_salida | fecha_regreso |
  | Lima      | Buenos Aires | 2024-08-1   | 2024-10-1    |
  | Medellin  | Bogota       | 2024-08-1   | 2024-10-1    |

