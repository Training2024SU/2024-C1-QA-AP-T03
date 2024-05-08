Feature: Busqueda de vuelo en la página de Latam

#autor
  Scenario Outline:Búsqueda de vuelos con diferentes fechas
    Given el usuario esta en la pagina de inicio de Latam
    When selecciona el origen "<origen>", destino "<destino>", fecha de salida "<fecha_salida>" y fecha de regreso "<fecha_regreso>"
    And hace click al boton de buscar
    Then el usuario debería ver una lista de vuelos disponibles
    Examples:
  | origen     | destino   | fecha_salida | fecha_regreso |
  | Lima  | Buenos Aires | 2024-06-01   | 2024-06-10    |

